package com.dchcompany.dchtesttask.service.serviceInterface;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<StudentReadDto> findAll();


    List<StudentReadDto> findAllByUniversity(Pageable pageable, String name);


    List<StudentReadDto> findAllByLecture(Pageable pageable, String name);


    Optional<StudentReadDto> findById(Long id);


    @Transactional
    StudentReadDto create(StudentCreateEditDto studentDto);


    @Transactional
    Optional<StudentReadDto> update(Long id, StudentCreateEditDto studentDto);


    @Transactional
    boolean delete(Long id);
}
