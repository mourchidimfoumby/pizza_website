package com.mfoumby.pizzawebsitebackend.features.auth;

import com.mfoumby.pizzawebsitebackend.features.auth.domain.JwtService;
import com.mfoumby.pizzawebsitebackend.features.auth.domain.entity.UserTokenInformation;
import com.mfoumby.pizzawebsitebackend.shared.CustomUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws IOException, ServletException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith(JwtService.TOKEN_TYPE + " ")) {
            token = token.substring(JwtService.TOKEN_TYPE.length() + 1);
            if (jwtService.validateAccessToken(token)) {
                UserTokenInformation userTokenInformation = jwtService.getUserTokenInformation(token);
                Authentication authentication = getAuthentication(userTokenInformation);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }

    private Authentication getAuthentication(UserTokenInformation userTokenInformation) {
        CustomUserDetails userDetails = new CustomUserDetails(
                userTokenInformation.userId(),
                userTokenInformation.role(),
                List.of(new SimpleGrantedAuthority("ROLE_" + userTokenInformation.role().name()))
        );
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
    }
}
