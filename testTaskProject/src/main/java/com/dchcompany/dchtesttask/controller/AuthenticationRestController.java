package com.dchcompany.dchtesttask.controller;

import com.dchcompany.dchtesttask.dto.AuthenticationRequestDto;
import com.dchcompany.dchtesttask.dto.UserReadDto;

import com.dchcompany.dchtesttask.security.jwt.JwtTokenProvider;
import com.dchcompany.dchtesttask.service.UserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.UnmodifiableSetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/api/v1/auth/")
@RequiredArgsConstructor
public class AuthenticationRestController {
    private  final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private  final UserService userService;


@PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto){
        try{
            String username=requestDto.getUsername();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,requestDto.getPassword()));
            UserReadDto userReadDto=userService.findByUsername(username).orElseThrow(() -> new UnmodifiableSetException());
            String token=jwtTokenProvider.createToken(username, userReadDto.getRole());

            Map<Object,Object> response=new HashMap<>();
            response.put("username", username);
            response.put("token", token);
            return ResponseEntity.ok(response);
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid username or password");

        }

    }
}
