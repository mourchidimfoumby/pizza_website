package com.mfoumby.pizzawebsitebackend.features.user;

import com.mfoumby.pizzawebsitebackend.features.user.data.UserRepository;
import com.mfoumby.pizzawebsitebackend.features.user.entity.User;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Nullable
    public User getUser(Long userId) {
        try {
            return userRepository.getUserFromId(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
