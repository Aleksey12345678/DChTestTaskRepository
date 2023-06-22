package com.dchcompany.dchtesttask.controller;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.dto.LectureReadDto;
import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.service.LectureService;
import com.dchcompany.dchtesttask.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;


@RestController
@RequestMapping("/api/v1/lectures")
@RequiredArgsConstructor
public class LectureRestController {
    private final LectureService lectureService;

    @GetMapping
    public List<LectureReadDto> findAll() {
        return lectureService.findAll();
    }

    @GetMapping("/{id}")
    public LectureReadDto findById(@PathVariable("id") Long id){
        return lectureService.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LectureReadDto create(@Validated @RequestBody LectureCreateEditDto lecture){
        return lectureService.create(lecture);
    }



    @PutMapping("/{id}")
    public LectureReadDto update(@PathVariable("id") Long id, @Validated @RequestBody LectureCreateEditDto lecture){
        return  lectureService.update(id,lecture)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        return  lectureService.delete(id)
                ?noContent().build()
                :notFound().build();
    }


}
