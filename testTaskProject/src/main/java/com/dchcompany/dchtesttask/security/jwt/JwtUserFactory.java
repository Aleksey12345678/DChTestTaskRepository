package com.dchcompany.dchtesttask.security.jwt;

import com.dchcompany.dchtesttask.dto.UserCreateEditDto;
import com.dchcompany.dchtesttask.dto.UserReadDto;
import com.dchcompany.dchtesttask.entity.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;

@Data
public class JwtUserFactory {
    public static JwtUser create(UserReadDto user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(user.getRole()));

    }

}
