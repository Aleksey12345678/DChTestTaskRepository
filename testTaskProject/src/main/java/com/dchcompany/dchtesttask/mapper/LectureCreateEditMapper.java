package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.entity.Lecture;
import com.dchcompany.dchtesttask.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LectureCreateEditMapper implements Mapper<LectureCreateEditDto, Lecture> {
    private final LectureRepository lectureRepository;

    @Override
    public Lecture map(LectureCreateEditDto object) {
        Lecture lecture=new Lecture();
        copy(object, lecture);
        return lecture;
    }

    @Override
    public Lecture map(LectureCreateEditDto fromObject, Lecture toObject) {
        copy(fromObject,toObject);
        return toObject;
    }


    private void copy(LectureCreateEditDto object, Lecture lecture){
        lecture.setName(object.getName());


    }

}
