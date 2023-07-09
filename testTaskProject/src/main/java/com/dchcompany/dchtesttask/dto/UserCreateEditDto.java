package com.dchcompany.dchtesttask.dto;

import com.dchcompany.dchtesttask.entity.Course;
import com.dchcompany.dchtesttask.entity.Role;
import com.dchcompany.dchtesttask.entity.University;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
public class UserCreateEditDto {
    @Size(min = 3, max = 20)
    String username;
    @Size(min = 3, max = 20)
    String password;
    Role role;

}
