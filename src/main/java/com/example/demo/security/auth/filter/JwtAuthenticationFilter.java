package com.example.demo.security.auth.filter;


import com.example.demo.entity.User;
import com.example.demo.security.auth.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.entity.Customer;
import com.example.demo.security.auth.JwtPayload;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Autowired
    private JwtService jwtService;

    private static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    private static final String ROLE_SELLER = "ROLE_SELLER";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String tokenHeader = "Bearer ";
        if (authHeader != null && authHeader.startsWith(tokenHeader)) {
            String authToken = authHeader.substring(tokenHeader.length());
            JwtPayload jwtPayload = jwtService.verifyJwt(authToken);
            if (jwtPayload != null && SecurityContextHolder.getContext().getAuthentication() == null
                    && jwtPayload.getExp() > System.currentTimeMillis()) {
                User user = jwtPayload.toUser();
                UsernamePasswordAuthenticationToken authentication;
                if (user.getRole() == null) {
                    authentication = new UsernamePasswordAuthenticationToken(user.getAccount(), null);
                } else {
                    authentication = new UsernamePasswordAuthenticationToken(user.getAccount(),
                            null, getAuthorities(user.getRole()));
                }
                authentication.setDetails(user);
                request.setAttribute("user", user);
                request.setAttribute("userId", user.getId());
                request.setAttribute("role", user.getRole());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            int role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (role == 1) {
            authorities.add(new SimpleGrantedAuthority(ROLE_SELLER));
        } else if (role == 0) {
            authorities.add(new SimpleGrantedAuthority(ROLE_CUSTOMER));
        }
        return authorities;
    }
}
