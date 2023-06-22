package com.dchcompany.dchtesttask.dto;

import com.dchcompany.dchtesttask.entity.Course;
import com.dchcompany.dchtesttask.entity.University;


import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.time.LocalDate;

@Value
public class StudentCreateEditDto {
    @Email
    String username;
    @DateTimeFormat (pattern = "dd.MM.yyyy")
    LocalDate birthDate;
    @Size(min = 3, max = 20)
    String firstname;
    @Size(min = 3, max = 20)
    String lastname;
    Course course;
    University university;
}
