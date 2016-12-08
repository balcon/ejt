CREATE SCHEMA unit8lib;

CREATE TABLE books (
  book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) NOT NULL,
  author varchar(255) NOT NULL,
  book_year INT NOT NULL
);

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL,
    phone varchar(20) NOT NULL
);

CREATE TABLE rents(
    rent_date varchar(20) NOT NULL,
    book_id INT,
    user_id INT
);