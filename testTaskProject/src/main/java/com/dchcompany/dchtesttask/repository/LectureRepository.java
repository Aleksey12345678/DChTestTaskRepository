package com.dchcompany.dchtesttask.repository;

import com.dchcompany.dchtesttask.entity.Lecture;
import com.dchcompany.dchtesttask.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture,Long> {
    List<Lecture> findAll();
    Optional< Lecture> findFirstById(Long id);
}
