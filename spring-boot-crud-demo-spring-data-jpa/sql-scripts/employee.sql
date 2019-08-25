CREATE DATABASE employee_directory;
/* 
After creating the database, create a new connection for it.
	host: localhost 
	database: employee_directory
	port: 5432
	user: postgres  (default user)
	pass: admin  (default password)
*/

DROP TABLE IF EXISTS employee;

CREATE SEQUENCE employee_seq;

CREATE TABLE employee (
  id int NOT NULL DEFAULT NEXTVAL ('employee_seq'),
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
);

INSERT INTO employee VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');

SELECT * FROM employee;