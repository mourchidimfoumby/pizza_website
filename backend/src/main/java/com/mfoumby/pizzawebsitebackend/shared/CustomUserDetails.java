package com.mfoumby.pizzawebsitebackend.shared;

import com.mfoumby.pizzawebsitebackend.features.user.entity.UserRole;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private Long id;
    private UserRole role;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(
            Long id,
            UserRole role,
            Collection<? extends GrantedAuthority> authorities
    ) {
        this.id = id;
        this.role = role;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public @NonNull Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return null;
    }

    @Override
    public @NonNull String getUsername() {
        return "";
    }
}
