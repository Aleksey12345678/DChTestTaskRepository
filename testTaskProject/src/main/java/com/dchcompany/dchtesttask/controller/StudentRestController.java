package com.dchcompany.dchtesttask.controller;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;


    @GetMapping
    public List<StudentReadDto> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/universityfilter")
    public List<StudentReadDto> findAllByUniversityFilter(@RequestParam(name = "limit") Integer limit, @RequestParam(name = "offset") Integer offset, @RequestParam(name = "university") String university) {
        List<StudentReadDto> list =  studentService.findAllByUniversity(PageRequest.of(offset, limit, Sort.by("id")), university);
        return list;

    }
    @GetMapping("/lecturefilter")
    public List<StudentReadDto> findAllByLectureFilter(@RequestParam(name = "limit") Integer limit, @RequestParam(name = "offset") Integer offset, @RequestParam(name = "lecture") String lecture) {
        List<StudentReadDto> list =  studentService.findAllByLecture(PageRequest.of(offset, limit, Sort.by("id")), lecture);
        return list;

    }

    @GetMapping("/{id}")
    public StudentReadDto findById(@PathVariable("id") Long id) {
        return studentService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public StudentReadDto create(@Validated @RequestBody StudentCreateEditDto student) {
        return studentService.create(student);
    }


    @PutMapping("/{id}")
    public StudentReadDto update(@PathVariable("id") Long id, @Validated @RequestBody StudentCreateEditDto student) {
        return studentService.update(id, student)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return studentService.delete(id)
                ? noContent().build()
                : notFound().build();
    }


}
