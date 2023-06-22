package com.dchcompany.dchtesttask.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "students_lecture")
public class StudentsLecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public void setStudent(Student student) {
        this.student = student;
        this.student.getStudentsLectures().add(this);
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
        this.lecture.getStudentsLectures().add(this);
    }
}
