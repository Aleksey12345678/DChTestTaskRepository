package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.UserCreateEditDto;
import com.dchcompany.dchtesttask.entity.Student;
import com.dchcompany.dchtesttask.entity.University;
import com.dchcompany.dchtesttask.entity.User;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        copy(object, user);
        return user;
    }

    @Override
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject, toObject);
        return toObject;
    }


    private void copy(UserCreateEditDto object, User user) {
        user.setUsername(object.getUsername());
        user.setPassword(passwordEncoder.encode(object.getPassword()));
        user.setRole(object.getRole());

    }

}
