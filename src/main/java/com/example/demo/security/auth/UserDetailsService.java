package com.example.demo.security.auth;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
@ComponentScan({"com.example.demo.service"})
public class UserDetailsService {
    @Autowired
    private UserService userService;

   /* @Value("${program.mp.webId}")
    private String webId;

    @Value("${program.mp.secret-key}")*/
    private String secret;
    private static final String KEY_OPEN_ID = "openId";
    private static final String KEY_ERR_CODE = "errCode";


    User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        return getUserByAccount(username);
    }

    private User getUserByAccount(String account)
            throws UsernameNotFoundException {
        User user = userService.getByAccount(account);
        if (user == null) {
            throw new UsernameNotFoundException("user name not found.");

        }

        return user;
    }
}

