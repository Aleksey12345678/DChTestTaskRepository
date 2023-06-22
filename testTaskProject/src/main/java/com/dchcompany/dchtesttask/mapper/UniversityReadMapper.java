package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.entity.University;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniversityReadMapper implements Mapper<University, UniversityReadDto> {
    @Override
    public UniversityReadDto map(University object) {
        return new UniversityReadDto(object.getId(),
                object.getName(),
                object.getAddress(),
                object.getEmail(),
                object.getPhone()
        );
    }
}
