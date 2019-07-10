package com.example.demo.security.auth;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/**
 * @author xzy
 * @date 2018-12-18
 * CustomAuthenticationProvider提供登录验证处理逻辑(处理认证请求)
 */
@Component
@Service("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{
    private static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";
    private static final String ROLE_SELLER = "ROLE_SELLER";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        User user = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken auth;
        if (comparePassword(authentication.getCredentials().toString(), user.getPassword())) {
            auth = new UsernamePasswordAuthenticationToken(username, null, getAuthorities(user.getRole()));
            auth.setDetails(user);
        } else {
            throw new BadCredentialsException("password error.");
        }
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }

    private boolean comparePassword(String input, String trusted) {
        return trusted.equals(input);
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Integer type) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (type == null) {
            return authorities;
        } else if (type == 0) {
            authorities.add(new SimpleGrantedAuthority(ROLE_CUSTOMER));
        } else if (type == 1) {
            authorities.add(new SimpleGrantedAuthority(ROLE_SELLER));
        }
        return authorities;
    }
}
