DROP TABLE IF EXISTS person;

CREATE TABLE Person (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO Person (first_name, last_name) VALUES
  ('Warren', 'Buffet'),
  ('Bill', 'Gates'),
  ('Steve', 'Jobs'),
  ('Mark', 'Twain'),
  ('Mark', 'Gates'),
  ('Zeus', 'God'),
  ('Blue', 'Jays'),
  ('Bruce', 'Lee'),
  ('Albert', 'Einstein');