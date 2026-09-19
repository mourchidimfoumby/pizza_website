package com.mfoumby.pizzawebsitebackend.features.auth.domain;

import com.mfoumby.pizzawebsitebackend.features.auth.InvalidCredentialsException;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.LoginResponse;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.OAuthToken;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.RegisterResponse;
import com.mfoumby.pizzawebsitebackend.features.user.data.UserMapper;
import com.mfoumby.pizzawebsitebackend.features.user.data.UserRepository;
import com.mfoumby.pizzawebsitebackend.features.user.entity.CreateUserRequest;
import com.mfoumby.pizzawebsitebackend.features.user.entity.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    public AuthService(
            UserRepository userRepository,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public LoginResponse login(String email, String password) {
        try {
            User user = userRepository.getUserFromEmail(email);
            if (!encoder.matches(password, user.password())) {
                throw new InvalidCredentialsException();
            }

            OAuthToken oAuthToken = jwtService.generateOAuthToken(user.id());
            return new LoginResponse(UserMapper.toUserResponse(user), oAuthToken);
        } catch (SQLException e) {
            throw new InvalidCredentialsException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public RegisterResponse register(CreateUserRequest createUserRequest) {
        try {
             Long userId = userRepository.createUser(createUserRequest);
             OAuthToken oAuthToken = jwtService.generateOAuthToken(userId);
             return new RegisterResponse(userId, oAuthToken);
         } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
