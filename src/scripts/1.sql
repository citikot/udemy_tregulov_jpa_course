CREATE TABLE test_db.passports (
  id BIGINT NOT NULL AUTO_INCREMENT,
  email VARCHAR(55),
  height INT,
  eye_color VARCHAR(25),
  PRIMARY KEY (id)
);

CREATE TABLE test_db.students (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(25),
  surname VARCHAR(25),
  avg_grade DOUBLE,
  passport_id BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (passport_id) REFERENCES test_db.passports(id)
);