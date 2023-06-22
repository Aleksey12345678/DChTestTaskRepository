package com.dchcompany.dchtesttask.repository;

import com.dchcompany.dchtesttask.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface UniversityRepository extends JpaRepository<University, Long> {
    List<University> findAll();
    Optional< University> findFirstById(Long id);
}
