package com.dchcompany.dchtesttask.service;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.dto.LectureReadDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ILectureService {
    List<LectureReadDto> findAll();

    Optional<LectureReadDto> findById(Long id);

    @Transactional
    LectureReadDto create(LectureCreateEditDto lectureDto);

    @Transactional
    Optional<LectureReadDto> update(Long id, LectureCreateEditDto lectureDto);

    @Transactional
    boolean delete(Long id);
}
