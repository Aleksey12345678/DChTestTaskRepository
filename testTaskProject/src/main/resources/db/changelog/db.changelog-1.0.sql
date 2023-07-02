--liquibase formatted sql

--changeset na:1
CREATE TABLE IF NOT EXISTS university
(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE,
    address VARCHAR(64),
    email VARCHAR(64),
    phone VARCHAR(64)

    );


CREATE TABLE IF NOT EXISTS students
(
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(64) NOT NULL UNIQUE ,
    birth_date DATE,
    firstname VARCHAR(64),
    lastname VARCHAR(64),
    course VARCHAR(32),
    university_id INT REFERENCES university (id)
);
CREATE TABLE IF NOT EXISTS lecture
(
    id BIGSERIAL PRIMARY KEY ,
    name VARCHAR(64) NOT NULL UNIQUE
);
CREATE TABLE IF NOT EXISTS students_lecture
(
    id BIGSERIAL PRIMARY KEY ,
    student_id BIGINT NOT NULL REFERENCES students (id) on delete CASCADE ,
    lecture_id BIGINT NOT NULL REFERENCES lecture (id),
    UNIQUE (student_id, lecture_id)
);
