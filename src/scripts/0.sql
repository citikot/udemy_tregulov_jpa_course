CREATE DATABASE  test_db;
USE test_db;

CREATE TABLE students (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name varchar(25),
  surname varchar(25),
  avg_grade DOUBLE,
  PRIMARY KEY (id)
);

