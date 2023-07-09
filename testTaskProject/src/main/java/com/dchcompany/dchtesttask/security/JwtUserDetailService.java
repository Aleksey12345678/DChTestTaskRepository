package com.dchcompany.dchtesttask.security;

import com.dchcompany.dchtesttask.dto.UserReadDto;
import com.dchcompany.dchtesttask.security.jwt.JwtUser;
import com.dchcompany.dchtesttask.security.jwt.JwtUserFactory;
import com.dchcompany.dchtesttask.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class JwtUserDetailService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserReadDto byUsername = userService.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("user not found"));
        JwtUser jwtUser = JwtUserFactory.create(byUsername);
        log.info("in loadUserByUsername, user with username: {} succsessfully loaded", username);
        return jwtUser;
    }
}
