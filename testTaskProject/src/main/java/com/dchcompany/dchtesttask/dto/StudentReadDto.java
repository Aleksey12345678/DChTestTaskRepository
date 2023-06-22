package com.dchcompany.dchtesttask.dto;

import com.dchcompany.dchtesttask.entity.Course;
import com.dchcompany.dchtesttask.entity.StudentsLecture;
import com.dchcompany.dchtesttask.entity.University;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Value
public class StudentReadDto {
    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    Course course;
    UniversityReadDto university;
}
