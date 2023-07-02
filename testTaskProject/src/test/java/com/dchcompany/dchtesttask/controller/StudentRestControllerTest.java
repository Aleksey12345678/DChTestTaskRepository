package com.dchcompany.dchtesttask.controller;

import com.dchcompany.dchtesttask.dto.StudentCreateEditDto;
import com.dchcompany.dchtesttask.dto.StudentReadDto;
import com.dchcompany.dchtesttask.entity.Course;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class StudentRestControllerTest {
    private final static String URL = "http://localhost:8080/";


    @Test
    @Order(1)
    void findAll() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX200());
        List<StudentReadDto> students = RestAssured.given()
                .log().all()
                .when()
                .get("api/v1/students")
                .then().log().all()

                .extract().body().jsonPath().getList("", StudentReadDto.class);

//        Assertions.assertTrue(students.stream().allMatch(x -> x.getUsername().endsWith("gmail.com")));
        Assertions.assertTrue(students.size()==5);
    }

    @Test
    @Order(6)
    void create() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX201());
        StudentCreateEditDto student = new StudentCreateEditDto("tes11t@gmail.com", LocalDate.of(1999, 11, 11), "testname", "lastname", Course.COURSE1, null);
        final StudentReadDto resultStudent = RestAssured.given()
                .log().all()
                .body(student)
                .when()
                .post("api/v1/students")
                .then().log().all()
                .extract().as(StudentReadDto.class);

        Assertions.assertTrue(student.getUsername().equals(resultStudent.getUsername()));

    }

    @Test
    @Order(5)
    void update() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX200());
        StudentCreateEditDto student = new StudentCreateEditDto("tes111t1@gmail.com", LocalDate.of(1999, 11, 11), "testname", "lastname", Course.COURSE1, null);
        Long id = 2L;
        final StudentReadDto resultStudent = RestAssured.given()
                .pathParam("id", id)
                .log().all()
                .body(student)
                .when()
                .put("api/v1/students/{id}")
                .then().log().all()
                .extract().as(StudentReadDto.class);

        Assertions.assertTrue(student.getUsername().equals(resultStudent.getUsername()));

    }

    @Test
    @Order(7)
    void delete() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX204());
        Long id = 2L;
        RestAssured.given()
                .pathParam("id", id)
                .log().all()
                .when()
                .delete("api/v1/students/{id}")
                .then().log().all()
                .extract().statusLine();

    }

    @Test
    @Order(2)
    void findById() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX200());
        Long id = 3L;
        StudentReadDto student = RestAssured.given()
                .log().all()
                .pathParam("id", id)
                .when()
                .get("api/v1/students/{id}")
                .then().log().all()

                .extract().body().jsonPath().getObject("", StudentReadDto.class);
        System.out.println(student);

        Assertions.assertTrue(student.getId() == id);
    }

    @Test
    @Order(3)
    void findAllByUniversityFilter() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX200());
        Long id = 3L;
        List<StudentReadDto> students = RestAssured.given()
                .log().all()
                .queryParams("limit", 5, "offset", 0, "university", "University1")

                .when()
                .get("api/v1/students/universityfilter")
                .then().log().all()

                .extract().body().jsonPath().getList("", StudentReadDto.class);


//        Assertions.assertTrue(students.stream().allMatch(x -> x.getUsername().endsWith("gmail.com")));
        Assertions.assertTrue(students.size()==2);
    }

    @Test
    @Order(4)
    void findAllByLectureFilter() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecGX200());
        Long id = 3L;
        List<StudentReadDto> students = RestAssured.given()
                .log().all()
                .queryParams("limit", 5, "offset", 0, "lecture", "lecture1")

                .when()
                .get("api/v1/students/lecturefilter")
                .then().log().all()

                .extract().body().jsonPath().getList("", StudentReadDto.class);


        Assertions.assertTrue(students.size()==3);
       // Assertions.assertTrue(students.stream().allMatch(x -> x.getUsername().endsWith("gmail.com")));
    }


}