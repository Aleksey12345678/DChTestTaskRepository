--liquibase formatted sql

--changeset na:1
INSERT INTO university (name, address, email, phone)
VALUES ('University1','addres1','university1@gmail.com','8-029-55551'),
       ('University2','addres2','university2@gmail.com','8-029-55552'),
       ('University3','addres3','university3@gmail.com','8-029-55553');


INSERT INTO students (birth_date, firstname, lastname, course, username, university_id)
VALUES ('1999-04-10', 'name1', 'lastname1', 'COURSE1', 'student1@gmail.com', (SELECT id FROM university WHERE name = 'University1')),
       ('1999-10-19', 'name2', 'lastname2', 'COURSE2', 'student2@gmail.com', (SELECT id FROM university WHERE name = 'University1')),
       ('1999-12-23', 'name3', 'lastname3', 'COURSE2', 'student3@gmail.com', (SELECT id FROM university WHERE name = 'University2')),
       ('1999-03-14', 'name4', 'lastname4', 'COURSE2', 'student4@gmail.com', (SELECT id FROM university WHERE name = 'University3')),
       ('1999-04-14', 'name5', 'lastname5', 'COURSE1', 'student5@gmail.com', (SELECT id FROM university WHERE name = 'University3'));

INSERT INTO lecture (name)
VALUES ('lecture1'),
       ('lecture2'),
       ('lecture3');

INSERT INTO students_lecture(student_id, lecture_id)
VALUES ((SELECT id FROM students WHERE username = 'student1@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture1')),
       ((SELECT id FROM students WHERE username = 'student2@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture1')),
       ((SELECT id FROM students WHERE username = 'student3@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture1')),
       ((SELECT id FROM students WHERE username = 'student4@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture2')),
       ((SELECT id FROM students WHERE username = 'student5@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture2')),
       ((SELECT id FROM students WHERE username = 'student1@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture2')),
       ((SELECT id FROM students WHERE username = 'student3@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture3')),
       ((SELECT id FROM students WHERE username = 'student4@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture3')),
       ((SELECT id FROM students WHERE username = 'student5@gmail.com'), (SELECT id FROM lecture WHERE name = 'lecture3'));
