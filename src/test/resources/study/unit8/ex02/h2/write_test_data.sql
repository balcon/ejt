INSERT INTO library.authors (name) VALUES ('author1');
INSERT INTO library.authors (name) VALUES ('author2');
INSERT INTO library.authors (name) VALUES ('author3');

INSERT INTO library.books (name, current_user_id) VALUES ('book1',1);
INSERT INTO library.books (name) VALUES ('book2');
INSERT INTO library.books (name) VALUES ('book3');
INSERT INTO library.books (name) VALUES ('book4');

INSERT INTO library.books_authors (book_id, author_id) VALUES (1,1);
INSERT INTO library.books_authors (book_id, author_id) VALUES (1,3);
INSERT INTO library.books_authors (book_id, author_id) VALUES (1,2);
INSERT INTO library.books_authors (book_id, author_id) VALUES (2,2);
INSERT INTO library.books_authors (book_id, author_id) VALUES (3,3);
INSERT INTO library.books_authors (book_id, author_id) VALUES (4,1);

INSERT INTO library.users (name,phone) VALUES ('user1','phone1');
INSERT INTO library.users (name,phone) VALUES ('John Smith','123-45-67');
INSERT INTO library.users (name,phone) VALUES ('Peter Johnson','234-56-78');
INSERT INTO library.users (name,phone) VALUES ('Roger Young','345-67-89');
INSERT INTO library.users (name,phone) VALUES ('Peter Smith','456-78-90');