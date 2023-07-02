package com.dchcompany.dchtesttask.controller;

import com.dchcompany.dchtesttask.dto.LectureCreateEditDto;
import com.dchcompany.dchtesttask.dto.LectureReadDto;
import com.dchcompany.dchtesttask.serviceFacade.LectureServiceFacade;
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
    private final LectureServiceFacade lectureServiceFacade;

    @GetMapping
    public List<LectureReadDto> findAll() {
        return lectureServiceFacade.findAll();
    }

    @GetMapping("/{id}")
    public LectureReadDto findById(@PathVariable("id") Long id){
        return lectureServiceFacade.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LectureReadDto create(@Validated @RequestBody LectureCreateEditDto lecture){
        return lectureServiceFacade.create(lecture);
    }



    @PutMapping("/{id}")
    public LectureReadDto update(@PathVariable("id") Long id, @Validated @RequestBody LectureCreateEditDto lecture){
        return  lectureServiceFacade.update(id,lecture)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        return  lectureServiceFacade.delete(id)
                ?noContent().build()
                :notFound().build();
    }


}
