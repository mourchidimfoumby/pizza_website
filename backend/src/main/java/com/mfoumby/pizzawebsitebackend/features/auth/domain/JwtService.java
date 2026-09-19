package com.mfoumby.pizzawebsitebackend.features.auth.domain;

import com.mfoumby.pizzawebsitebackend.features.auth.HashingUtils;
import com.mfoumby.pizzawebsitebackend.features.auth.InvalidCredentialsException;
import com.mfoumby.pizzawebsitebackend.features.auth.data.RefreshTokenRepository;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.OAuthToken;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.RefreshToken;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.UserTokenInformation;
import com.mfoumby.pizzawebsitebackend.features.user.data.UserRepository;
import com.mfoumby.pizzawebsitebackend.features.user.entity.User;
import com.mfoumby.pizzawebsitebackend.features.user.entity.UserRole;
import com.mfoumby.pizzawebsitebackend.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class JwtService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final SecretKey secretKey;
    public static final Duration ACCESS_TOKEN_EXPIRATION_TIME = Duration.ofMinutes(15);
    public static final Duration REFRESH_TOKEN_EXPIRATION_TIME = Duration.ofDays(7);
    public static final String TOKEN_TYPE = "Bearer";

    public JwtService(
            JwtProperties jwtProperties,
            RefreshTokenRepository refreshTokenRepository,
            UserRepository userRepository
    ) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
        this.secretKey = Keys.hmacShaKeyFor(jwtProperties.secret().getBytes());
    }

    public OAuthToken renewAccessToken(String refreshToken) {
        try {
            RefreshToken refreshTokenEntity = refreshTokenRepository.getRefreshTokenFromToken(refreshToken);
            boolean validRefreshToken = Objects.equals(refreshToken, refreshTokenEntity.tokenHash()) &&
                    refreshTokenEntity.expiresAt().isAfter(Instant.now());
            if (!validRefreshToken) {
                throw new InvalidCredentialsException("Invalid token");
            }
            return generateOAuthToken(refreshTokenEntity.userId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public OAuthToken generateOAuthToken(Long userId) {
        try {
            String accessToken = generateAccessToken(userId);
            return new OAuthToken(
                    accessToken,
                    TOKEN_TYPE,
                    ACCESS_TOKEN_EXPIRATION_TIME.toMillis()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String generateRefreshToken(Long userId) {
        try {
            byte[] random = new byte[64];
            new SecureRandom().nextBytes(random);
            String token = Base64.getUrlEncoder()
                    .withoutPadding()
                    .encodeToString(random);
            RefreshToken refreshToken = new RefreshToken(
                    UUID.randomUUID().toString(),
                    userId,
                    HashingUtils.sha256Hex(token),
                    Instant.now().plus(REFRESH_TOKEN_EXPIRATION_TIME)
            );
            refreshTokenRepository.upsertRefreshToken(refreshToken);
            return refreshToken.tokenHash();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public UserTokenInformation getUserTokenInformation(String accessToken) {
         Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(accessToken)
                .getPayload();

         return new UserTokenInformation(
                 Long.valueOf(claims.getSubject()),
                 UserRole.fromId(claims.get("userRoleId", Integer.class))
         );
    }

    private String generateAccessToken(Long userId) {
        try {
            User user = userRepository.getUserFromId(userId);
            return Jwts.builder()
                    .subject(userId.toString())
                    .claim("userRoleId", user.roleId())
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME.toMillis()))
                    .signWith(secretKey)
                    .compact();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
