package com.dchcompany.dchtesttask.serviceFacade;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.dto.LectureReadDto;
import com.dchcompany.dchtesttask.service.ILectureService;
import com.dchcompany.dchtesttask.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LectureServiceFacade implements ILectureServiceFacade {

    private final ILectureService lectureService;

    @Override
    public List<LectureReadDto> findAll() {
        return lectureService.findAll();
    }

    @Override
    public Optional<LectureReadDto> findById(Long id) {
        return lectureService.findById(id);
    }

    @Override
    public LectureReadDto create(LectureCreateEditDto lectureDto) {
        return lectureService.create(lectureDto);
    }


    @Override
    public Optional<LectureReadDto> update(Long id, LectureCreateEditDto lectureDto) {
        return lectureService.update(id,lectureDto);
    }


    @Override
    public boolean delete(Long id) {
        return lectureService.delete(id);}
}
