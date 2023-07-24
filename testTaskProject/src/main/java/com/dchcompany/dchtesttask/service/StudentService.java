package com.dchcompany.dchtesttask.service;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.mapper.StudentCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.StudentReadMapper;
import com.dchcompany.dchtesttask.repository.StudentRepository;
import com.dchcompany.dchtesttask.service.serviceInterface.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;
    private final StudentReadMapper  studentReadMapper;
    private final StudentCreateEditMapper studentCreateEditMapper;

    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<StudentReadDto> findAll(){
        return studentRepository.findAll().stream()
                .map(studentReadMapper::map)
                .toList();
    }
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<StudentReadDto> findAllByUniversity(Pageable pageable, String name){
        return studentRepository.findAllByUniversity(pageable, name).stream()
                .map(studentReadMapper::map)
                .toList();
    }
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<StudentReadDto> findAllByLecture(Pageable pageable, String name){
        return studentRepository.findAllByLecture(pageable, name).stream()
                .map(studentReadMapper::map)
                .toList();
    }
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Optional<StudentReadDto > findById(Long id){
        return studentRepository.findFirstById(id)
                .map(studentReadMapper::map);
    }
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @Transactional
    public StudentReadDto create(StudentCreateEditDto studentDto){
        return Optional.of(studentDto)
                .map(dto->studentCreateEditMapper.map(dto))
                .map(studentRepository::save)
                .map(studentReadMapper::map)
                .orElseThrow();
    }
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @Transactional
    public Optional<StudentReadDto> update(Long id, StudentCreateEditDto studentDto){
        return studentRepository.findById(id)
                .map(entity-> studentCreateEditMapper.map(studentDto, entity))
                .map(studentRepository::saveAndFlush)
                .map(studentReadMapper::map);
    }
    @Override
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @Transactional
    public boolean delete(Long id){
        return studentRepository.findById(id)
                .map(entity->{
                    studentRepository.delete(entity);
                            studentRepository.flush();
                            return true;
                })
                .orElse(false);
    }
}
