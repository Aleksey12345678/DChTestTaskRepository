package com.dchcompany.dchtesttask.serviceFacade;

import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.mapper.UniversityCreateEditMapper;
import com.dchcompany.dchtesttask.mapper.UniversityReadMapper;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import com.dchcompany.dchtesttask.service.IUniversityService;
import com.dchcompany.dchtesttask.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UniversityServiceFacade implements IUniversityServiceFacade {

    private final IUniversityService universityService;

    @Override
    public List<UniversityReadDto> findAll(){
        return universityService.findAll();
    }
    @Override
    public Optional<UniversityReadDto > findById(Long id){
        return universityService.findById(id);
    }

    @Override
    public UniversityReadDto create(UniversityCreateEditDto universityDto){
        return universityService.create(universityDto);
    }

    @Override
    public Optional<UniversityReadDto> update(Long id, UniversityCreateEditDto universityDto){
        return universityService.update(id ,universityDto);
    }

    @Override
    public boolean delete(Long id){
        return universityService.delete(id);
    }
}
