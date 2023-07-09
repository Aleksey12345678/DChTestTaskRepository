package com.dchcompany.dchtesttask.service;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.dto.LectureReadDto;
import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.mapper.LectureCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.LectureReadMapper;
import com.dchcompany.dchtesttask.mapper.UniversityCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.UniversityReadMapper;
import com.dchcompany.dchtesttask.repository.LectureRepository;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectureService implements  ILectureService {
    private final LectureRepository lectureRepository;
    private final LectureReadMapper lectureReadMapper;
    private final LectureCreateEditMapper lectureCreateEditMapper;

    @Override
    public List<LectureReadDto> findAll() {
        return lectureRepository.findAll().stream()
                .map(lectureReadMapper::map)
                .toList();
    }

    @Override
    public Optional<LectureReadDto> findById(Long id) {
        return lectureRepository.findFirstById(id)
                .map(lectureReadMapper::map);
    }

    @Override
    @Transactional
    public LectureReadDto create(LectureCreateEditDto lectureDto) {
        return Optional.of(lectureDto)
                .map(dto -> lectureCreateEditMapper.map(dto))
                .map(lectureRepository::save)
                .map(lectureReadMapper::map)
                .orElseThrow();
    }

    @Override
    @Transactional
    public Optional<LectureReadDto> update(Long id, LectureCreateEditDto lectureDto) {
        return lectureRepository.findById(id)
                .map(entity -> lectureCreateEditMapper.map(lectureDto, entity))
                .map(lectureRepository::saveAndFlush)
                .map(lectureReadMapper::map);
    }

    @Override
    @Transactional
    public boolean delete(Long id) {
        return lectureRepository.findById(id)
                .map(entity -> {
                    lectureRepository.delete(entity);
                    lectureRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}
