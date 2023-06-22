package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.LectureReadDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.entity.Lecture;
import com.dchcompany.dchtesttask.entity.University;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LectureReadMapper implements Mapper<Lecture, LectureReadDto> {
    @Override
    public LectureReadDto map(Lecture object) {
        return new LectureReadDto(object.getId(),
                object.getName());
    }
}
