package com.dchcompany.dchtesttask.serviceFacade;

import com.dchcompany.dchtesttask.dto.LectureReadDto;
import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.mapper.StudentCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.StudentReadMapper;
import com.dchcompany.dchtesttask.repository.StudentRepository;
import com.dchcompany.dchtesttask.service.LectureService;
import com.dchcompany.dchtesttask.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceFacade {

    private final StudentService studentService;
    private final LectureService lectureService;

    @Transactional
    public StudentReadDto create(StudentCreateEditDto studentDto) {
        final StudentReadDto studentReadDto = studentService.create(studentDto);
        final List<LectureReadDto> lectureList = lectureService.findAll();
        final String email = studentDto.getUsername();
        System.out.println( "send mail with list lectures " +lectureList+"to "+email);
        return studentReadDto;

    }



    public List<StudentReadDto> findAll() {
        return studentService.findAll();
    }

    public List<StudentReadDto> findAllByUniversity(Pageable pageable, String name) {
        return studentService.findAllByUniversity(pageable, name);
    }

    public List<StudentReadDto> findAllByLecture(Pageable pageable, String name) {
        return studentService.findAllByLecture(pageable, name);
    }

    public Optional<StudentReadDto> findById(Long id) {
        return studentService.findById(id);
    }



    @Transactional
    public Optional<StudentReadDto> update(Long id, StudentCreateEditDto studentDto) {
        return studentService.update(id, studentDto);
    }

    @Transactional
    public boolean delete(Long id) {
        return studentService.delete(id);
    }
}