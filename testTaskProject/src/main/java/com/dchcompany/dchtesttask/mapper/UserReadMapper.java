package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.dto.UserReadDto;
import com.dchcompany.dchtesttask.entity.Student;
import com.dchcompany.dchtesttask.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                object.getId(),
                object.getUsername(),
               object.getPassword(),
                object.getRole()
        );
    }


}
