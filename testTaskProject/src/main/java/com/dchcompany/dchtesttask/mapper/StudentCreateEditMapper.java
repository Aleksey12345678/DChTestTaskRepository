package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.entity.Student;
import com.dchcompany.dchtesttask.entity.University;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class StudentCreateEditMapper implements Mapper<StudentCreateEditDto, Student> {
    private final UniversityRepository universityRepository;

    @Override
    public Student map(StudentCreateEditDto object) {
        Student student=new Student();
        copy(object, student);
        return student;
    }

    @Override
    public Student map(StudentCreateEditDto fromObject, Student toObject) {
       copy(fromObject,toObject);
       return toObject;
    }


    private void copy(StudentCreateEditDto object, Student student){
        student.setUsername(object.getUsername());
        student.setFirstname(object.getFirstname());
        student.setLastname(object.getLastname());
        student.setBirthDate(object.getBirthDate());
        student.setCourse(object.getCourse());
        student.setUniversity(object.getUniversity());
    }
    public University getUniversity(Long universityId){
        return Optional.ofNullable(universityId)
                .flatMap(universityRepository::findById)
                .orElse(null);
    }
}
