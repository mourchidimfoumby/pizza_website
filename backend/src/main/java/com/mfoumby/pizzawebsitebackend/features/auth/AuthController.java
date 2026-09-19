package com.mfoumby.pizzawebsitebackend.features.auth;

import com.mfoumby.pizzawebsitebackend.features.auth.domain.AuthService;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.JwtService;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.LoginResponse;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.OAuthToken;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.RegisterResponse;
import com.mfoumby.pizzawebsitebackend.features.user.entity.CreateUserRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final JwtService jwtService;
    private final String REFRESH_TOKEN_COOKIE_NAME = "refresh_token";

    public AuthController(
            AuthService authService,
            JwtService jwtService
    ) {
        this.authService = authService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody String email, @RequestBody String password) {
        LoginResponse loginResponse = authService.login(email, password);

        String refreshToken = jwtService.generateRefreshToken(loginResponse.user().userId());
        ResponseCookie refreshTokenCookie = formatRefreshTokenCookie(refreshToken);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());

        return new ResponseEntity<>(
                loginResponse,
                headers,
                HttpStatus.OK
        );
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody CreateUserRequest createUserRequest) {
        RegisterResponse registerResponse = authService.register(createUserRequest);

        String refreshToken = jwtService.generateRefreshToken(registerResponse.userId());
        ResponseCookie refreshTokenCookie = formatRefreshTokenCookie(refreshToken);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, refreshTokenCookie.toString());

        return new ResponseEntity<>(
                registerResponse,
                headers,
                HttpStatus.OK
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<OAuthToken> refresh(@CookieValue(REFRESH_TOKEN_COOKIE_NAME) String refreshToken) {
        return ResponseEntity.ok(jwtService.renewAccessToken(refreshToken));
    }

    private ResponseCookie formatRefreshTokenCookie(String refreshToken) {
        return ResponseCookie
                .from(REFRESH_TOKEN_COOKIE_NAME, refreshToken)
                .httpOnly(true)
//                .secure(true)
                .sameSite("Strict")
                .path("/auth/refresh")
                .maxAge(JwtService.REFRESH_TOKEN_EXPIRATION_TIME)
                .build();
    }
}
