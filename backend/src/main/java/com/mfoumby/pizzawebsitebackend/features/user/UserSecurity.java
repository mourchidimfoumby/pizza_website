package com.mfoumby.pizzawebsitebackend.features.user;

import com.mfoumby.pizzawebsitebackend.shared.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserSecurity {
    public boolean isOwner(Long id, Authentication authentication) {
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user.getId().equals(id);
    }
}
