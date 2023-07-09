package com.dchcompany.dchtesttask.dto;

import com.dchcompany.dchtesttask.entity.Course;
import com.dchcompany.dchtesttask.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    String password;
    Role role;
}
