CREATE TABLE test_db.universities (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(25),
  founding_date DATE,
  PRIMARY KEY (id)
);

CREATE TABLE test_db.students (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(25),
  surname VARCHAR(25),
  avg_grade DOUBLE,
  university_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (university_id) REFERENCES test_db.universities(id)
);