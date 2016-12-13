CREATE SCHEMA library;

CREATE TABLE library.books (
  book_id INT NOT NULL PRIMARY KEY,
  name varchar(255) NOT NULL,
  author varchar(255) NOT NULL,
  book_year INT NOT NULL
);

CREATE TABLE library.users (
    user_id INT NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    phone varchar(20) NOT NULL
);
