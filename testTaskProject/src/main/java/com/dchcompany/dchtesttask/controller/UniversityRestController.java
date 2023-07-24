package com.dchcompany.dchtesttask.controller;

import com.dchcompany.dchtesttask.dto.UniversityCreateEditDto;
import com.dchcompany.dchtesttask.dto.UniversityReadDto;
import com.dchcompany.dchtesttask.serviceFacade.facadeInterface.IUniversityServiceFacade;
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
@RequestMapping("/api/v1/universities")
@RequiredArgsConstructor
public class UniversityRestController {
    private final IUniversityServiceFacade universityServiceFacade;

    @GetMapping
    public List<UniversityReadDto> findAll() {
        return universityServiceFacade.findAll();
    }

    @GetMapping("/{id}")
    public UniversityReadDto findById(@PathVariable("id") Long id){
        return universityServiceFacade.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UniversityReadDto create(@Validated @RequestBody UniversityCreateEditDto university){
        return universityServiceFacade.create(university);
    }



    @PutMapping("/{id}")
    public UniversityReadDto update(@PathVariable("id") Long id, @Validated @RequestBody UniversityCreateEditDto university){
        return  universityServiceFacade.update(id,university)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        return  universityServiceFacade.delete(id)
                ?noContent().build()
                :notFound().build();
    }


}
