package com.dchcompany.dchtesttask.mapper;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.entity.Student;
import com.dchcompany.dchtesttask.entity.University;
import com.dchcompany.dchtesttask.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UniversityCreateEditMapper implements Mapper<UniversityCreateEditDto, University> {
    private final UniversityRepository universityRepository;

    @Override
    public University map(UniversityCreateEditDto object) {
        University university=new University();
        copy(object, university);
        return university;
    }

    @Override
    public University map(UniversityCreateEditDto fromObject, University toObject) {
       copy(fromObject,toObject);
       return toObject;
    }


    private void copy(UniversityCreateEditDto object, University university){
        university.setName(object.getName());
        university.setAddress(object.getAddress());
        university.setEmail(object.getEmail());
        university.setPhone(object.getPhone());

    }

}
