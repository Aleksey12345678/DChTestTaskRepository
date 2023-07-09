package com.dchcompany.dchtesttask.serviceFacade;

import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;

import java.util.List;
import java.util.Optional;

public interface IUniversityServiceFacade {
    List<UniversityReadDto> findAll();

    Optional<UniversityReadDto> findById(Long id);

    UniversityReadDto create(UniversityCreateEditDto universityDto);

    Optional<UniversityReadDto> update(Long id, UniversityCreateEditDto universityDto);

    boolean delete(Long id);
}
