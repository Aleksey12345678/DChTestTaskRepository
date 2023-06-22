package com.dchcompany.dchtesttask.repository;

import com.dchcompany.dchtesttask.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();

    Optional<Student> findFirstById(Long id);

    @Query(value = "select s from University u " +
            "join u.students s " +
            "where u.name = :universityName")
    Page<Student> findAllByUniversity(Pageable pageable, String universityName);

    @Query(value = "select s from Lecture l join l.studentsLectures sl join sl.student s where l.name = :lectureName")
    Page<Student> findAllByLecture(Pageable pageable, String lectureName);
}

