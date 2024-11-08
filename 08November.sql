create database banking;
use banking;
create table customer(
customer_id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
phone VARCHAR(15),
email VARCHAR(100),
address VARCHAR(255));
alter table customer modify column phone bigint;
alter table customer drop column email;
drop table customer;
create table customer(
customer_id INT auto_increment PRIMARY KEY,
name VARCHAR(100) NOT NULL,
phone VARCHAR(15),
email VARCHAR(100),
address VARCHAR(255));
alter table customer modify column phone bigint;
insert into customer(customer_id,name,phone,email,address) values
(1,'John',1234567890,'john@example.com','123 Maple street'),
(2, 'Jane Smith', 9876543210, 'janesmith@example.com', '456 Oak Avenue'),
(3, 'Alice Johnson', 5555555555, 'alicej@example.com', '789 Pine Road'),
(4, 'Bob Brown', 1112233445, 'bobbrown@example.com', '101 Elm Street'),
(5, 'Charlie White', 9876549876, 'charliew@example.com', '202 Birch Lane'),
(6, 'Diana Green', 4321567890, 'dianagreen@example.com', '303 Cedar Blvd'),
(7, 'Eve Black', 5432167890, 'eveblack@example.com', '404 Oakwood Dr'),
(8, 'Frank Blue', 6543218765, 'frankblue@example.com', '505 Pinehill Rd'),
(9, 'Grace Yellow', 7654321098, 'graceyellow@example.com', '606 Maplewood Ave'),
(10, 'Harry Red', 8765432109, 'harryred@example.com', '707 Redwood Path');
select * from customer;
update customer set email = 'newemail@example.com' where customer_id = 1;
delete from customer where customer_id = 1;
select * from customer where email is not null;
CREATE TABLE student (customercustomercustomercustomer
id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
address VARCHAR(255),
department VARCHAR(100)
);
INSERT INTO student (id, name, address, department)
VALUES 
(1, 'John Doe', '123 Main St, Cityville', 'Computer Science'),
(2, 'Jane Smith', '456 Oak St, Townsville', 'Mathematics'),
(3, 'Alice Johnson', '789 Pine St, Villagetown', 'Physics'),
(4, 'Bob Brown', '101 Elm St, Citytown', 'Chemistry'),
(5, 'Charlie White', '202 Maple St, Suburbia', 'Biology'),
(6, 'David Green', '303 Birch St, Uptown', 'English Literature'),
(7, 'Eve Black', '404 Cedar St, Downtown', 'History'),
(8, 'Frank Blue', '505 Pine St, Rivertown', 'Psychology'),
(9, 'Grace Yellow', '606 Willow St, Oldtown', 'Economics'),
(10, 'Harry Red', '707 Redwood St, Newcity', 'Engineering');
select * from student where department in('Computer Science','Mathematics','Physics');
select * from student where id between 2 and 5;
select * from student order by name asc;
select * from student order by department desc limit 3;
CREATE TABLE employee (
id INT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
salary DECIMAL(10, 2),
address VARCHAR(255)
);
INSERT INTO employee (id, name, salary, address) 
VALUES 
(1, 'John Doe', 55000.00, '123 Main St, Cityville'),
(2, 'Jane Smith', 62000.50, '456 Oak St, Townsville'),
(3, 'Alice Johnson', 47000.75, '789 Pine St, Villagetown'),
(4, 'Bob Brown', 53000.00, '101 Elm St, Citytown'),
(5, 'Charlie White', 58000.25, '202 Maple St, Suburbia'),
(6, 'David Green', 61000.00, '303 Birch St, Uptown'),
(7, 'Eve Black', 49500.00, '404 Cedar St, Downtown'),
(8, 'Frank Blue', 56000.50, '505 Pine St, Rivertown'),
(9, 'Grace Yellow', 63000.75, '606 Willow St, Oldtown'),
(10, 'Harry Red', 67000.00, '707 Redwood St, Newcity');
SELECT SUM(salary) AS total_salary
FROM employee;
select avg(salary) as avaerage_salary from employee;
SELECT MAX(salary) AS highest_salary, MIN(salary) AS lowest_salary
FROM employee;
SELECT COUNT(id) AS total_employees
FROM employee;
ALTER TABLE student
ADD COLUMN department_id INT;
CREATE TABLE departments (
    department_id INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    student_id INT,
    FOREIGN KEY (student_id) REFERENCES student(id)
);
SELECT s.id AS student_id, s.name AS student_name, s.address AS student_address, 
       e.id AS employee_id, e.salary AS employee_salary, e.address AS employee_address
FROM student s
JOIN employee e ON s.name = e.name;
SELECT s.id AS student_id, s.name AS student_name, s.address AS student_address, 
       e.id AS employee_id, e.salary AS employee_salary, e.address AS employee_address
FROM student s
INNER JOIN employee e ON s.name = e.name;
SELECT s.id AS student_id, s.name AS student_name, s.address AS student_address, 
       e.id AS employee_id, e.name AS employee_name, e.salary AS employee_salary, e.address AS employee_address
FROM student s
RIGHT JOIN employee e ON s.name = e.name;



