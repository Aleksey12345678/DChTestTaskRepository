package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.entity.Student;
import com.dchcompany.dchtesttask.entity.University;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentReadMapper implements Mapper<Student, StudentReadDto> {
    private final UniversityReadMapper universityReadMapper;

    @Override
    public StudentReadDto map(Student object) {
        UniversityReadDto universityReadDto = Optional.ofNullable(object.getUniversity())
                .map(universityReadMapper::map)
                .orElse(null);
        return new StudentReadDto(
                object.getId(),
                object.getUsername(),
                object.getBirthDate(),
                object.getFirstname(),
                object.getLastname(),
                object.getCourse(),
                universityReadDto

        );
    }


}
