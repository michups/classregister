DROP DATABASE IF EXISTS class_register_db;

DROP USER IF EXISTS 'teacher';

CREATE DATABASE class_register_db;

CREATE USER 'teacher' IDENTIFIED BY 't3ach3r';

GRANT ALL ON class_register_db.* TO 'teacher';

USE class_register_db;


CREATE TABLE grade (
  grade_id int(11) NOT NULL AUTO_INCREMENT,
  number int(1) NOT NULL,
  alfabet_digit varchar(45) NOT NULL,
  year int(4) NOT NULL,
  PRIMARY KEY (grade_id)
);

CREATE TABLE student (
  student_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  grade_id INT NOT NULL,
  birth_date DATETIME,
  PRIMARY KEY (student_id),
  FOREIGN KEY (grade_id) REFERENCES grade (grade_id)
);

CREATE TABLE teacher (
  teacher_id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  grade_id INT ,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (teacher_id),
  FOREIGN KEY (grade_id) REFERENCES grade (grade_id)
);


CREATE TABLE teacher_grade (
	teacher_id INT NOT NULL,
  grade_id INT NOT NULL,
  PRIMARY KEY (teacher_id, grade_id),
  FOREIGN KEY (teacher_id) REFERENCES teacher (teacher_id),
  FOREIGN KEY (grade_id) REFERENCES grade (grade_id)
);

INSERT INTO grade (number, alfabet_digit, year) VALUES
(1, 'a', 1999),
(1, 'b', 1999),
(1, 'c', 1999),
(2, 'a', 1998),
(2, 'b', 1998),
(2, 'c', 1998),
(3, 'a', 1997);

INSERT INTO  teacher (first_name, last_name, grade_id, email)VALUES
("Irene",	"Cooper", NULL, "irene@cooper.com"),
("Kenneth",	"Reed", 1, "kenneth@reed.com"),
("James",	"Coleman", 2, "james@coleman.com"),
("Deborah",	"Henderson",3, "deborah@henderson.com"),
("Thomas",	"Bailey",4 , "thomas@bailey.com"),
("Tina",	"Walker",5, "tina@walker.com"),
("Randy",	"Lee",6, "randy@lee.com"),
("Wayne",	"Brooks",7, "wayne@brooks.com"),
("Daniel",	"Hall", NULL, "daniel@hall.com"),
("Melissa",	"ewis", NULL, "melissa@ewis.com");


INSERT INTO teacher_grade (teacher_id, grade_id)VALUES
(1,1),(1,2),(1,3),(1,4),
(2,1),(2,2),(2,3),(2,7),
(3,7),(3,6),(3,4),(4,3),
(5,5),(5,3),(5,2),(6,6),
(7,7),(8,6),(9,3),(10,2);


INSERT INTO  student ( first_name , last_name, email,  grade_id, birth_date) VALUES

("Grace",	  "Cook",     "grace@gmail.com",  1, '1993-07-01'),
("Penny",	  "Mccoy",    "penny@gmail.com",  2, '1993-01-02'),
("Benny",	  "Morgan",   "benny@gmail.com",  3, '1993-04-03'),
("Rafael",	"Robbins",  "rafael@gmail.com", 4, '1994-05-04'),
("Lillian", "Carson",   "lillian@gmail.com",5, '1992-07-05'),
("Lori",	  "Williams", "lori@gmail.com",   5, '1992-02-06'),
("Morris",	"Bell",     "morris@gmail.com", 6, '1992-05-07'),
("Ramona",	"opeland",  "ramona@gmail.com", 7, '1991-12-08'),
("Maria",	  "Lane",     "maria@gmail.com",  7, '1991-11-09'),
("Paul",	  "Reynolds", "paul@gmail.com",   6, '1992-09-30')
;