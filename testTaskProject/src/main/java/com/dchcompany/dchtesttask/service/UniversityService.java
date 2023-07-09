package com.dchcompany.dchtesttask.service;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.mapper.StudentCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.StudentReadMapper;
import com.dchcompany.dchtesttask.mapper.UniversityCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.UniversityReadMapper;
import com.dchcompany.dchtesttask.repository.StudentRepository;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UniversityService implements IUniversityService {
    private final UniversityRepository universityRepository;
    private final UniversityReadMapper universityReadMapper;
    private final UniversityCreateEditMapper universityCreateEditMapper;

    @Override
    public List<UniversityReadDto> findAll(){
        return universityRepository.findAll().stream()
                .map(universityReadMapper::map)
                .toList();
    }
    @Override
    public Optional<UniversityReadDto > findById(Long id){
        return universityRepository.findFirstById(id)
                .map(universityReadMapper::map);
    }
    @Override
    @Transactional
    public UniversityReadDto create(UniversityCreateEditDto universityDto){
        return Optional.of(universityDto)
                .map(dto->universityCreateEditMapper.map(dto))
                .map(universityRepository::save)
                .map(universityReadMapper::map)
                .orElseThrow();
    }
    @Override
    @Transactional
    public Optional<UniversityReadDto> update(Long id, UniversityCreateEditDto universityDto){
        return universityRepository.findById(id)
                .map(entity-> universityCreateEditMapper.map(universityDto, entity))
                .map(universityRepository::saveAndFlush)
                .map(universityReadMapper::map);
    }
    @Override
    @Transactional
    public boolean delete(Long id){
        return universityRepository.findById(id)
                .map(entity->{
                    universityRepository.delete(entity);
                    universityRepository.flush();
                            return true;
                })
                .orElse(false);
    }
}
