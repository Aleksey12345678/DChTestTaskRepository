package com.dchcompany.dchtesttask.service;

import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IUniversityService {
    List<UniversityReadDto> findAll();

    Optional<UniversityReadDto> findById(Long id);

    @Transactional
    UniversityReadDto create(UniversityCreateEditDto universityDto);

    @Transactional
    Optional<UniversityReadDto> update(Long id, UniversityCreateEditDto universityDto);

    @Transactional
    boolean delete(Long id);
}
