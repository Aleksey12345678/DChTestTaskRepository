package com.dchcompany.dchtesttask.serviceFacade.facadeInterface;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.dto.LectureReadDto;

import java.util.List;
import java.util.Optional;

public interface ILectureServiceFacade {
    List<LectureReadDto> findAll();

    Optional<LectureReadDto> findById(Long id);

    LectureReadDto create(LectureCreateEditDto lectureDto);

    Optional<LectureReadDto> update(Long id, LectureCreateEditDto lectureDto);

    boolean delete(Long id);
}
