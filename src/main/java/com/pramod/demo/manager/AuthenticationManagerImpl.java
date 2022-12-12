package com.pramod.demo.manager;

import com.pramod.demo.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationManagerImpl implements AuthenticationManager {

    private final UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";

        UserDetails user = userDao.findByUserName(username);
        if (user == null) {
            throw new BadCredentialsException("1000");
        }
        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("1000");
        }
//        if (user.isDisabled()) {
//            throw new DisabledException("1001");
//        }
//        List<Right> userRights = rightRepo.getUserRights(username);
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}
