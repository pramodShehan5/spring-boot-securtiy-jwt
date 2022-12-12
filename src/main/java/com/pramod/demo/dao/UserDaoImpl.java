package com.pramod.demo.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User("pramodshehan@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("admin")))
    );

    @Override
    public UserDetails findByUserName(String userName) {
        return APPLICATION_USERS.stream().filter(user -> user.getUsername().equals(userName)).findFirst().orElseThrow();
    }
}
