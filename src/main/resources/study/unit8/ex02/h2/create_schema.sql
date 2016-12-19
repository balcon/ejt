CREATE SCHEMA library;

CREATE TABLE library.books (
  book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(255) NOT NULL,
  author_id INT NOT NULL
);

CREATE TABLE library.authors(
    author_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(255) NOT NULL
);

CREATE TABLE library.users (
    user_id INT NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    phone varchar(20) NOT NULL
);
