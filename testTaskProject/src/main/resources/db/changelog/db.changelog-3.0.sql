--liquibase formatted sql

--changeset na:1
CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(64) NOT NULL UNIQUE ,
   password VARCHAR(64) NOT NULL,
   role VARCHAR(32)
);
INSERT INTO users (username, password, role)
VALUES ('user', '$2a$10$u7MVJEDajG2zjwnbyBWH9.9RVitgOyT7/9LGTAyjTSM2YBdsQcwae', 'USER'),
       ('admin', '$2a$10$u7MVJEDajG2zjwnbyBWH9.9RVitgOyT7/9LGTAyjTSM2YBdsQcwae', 'ADMIN');