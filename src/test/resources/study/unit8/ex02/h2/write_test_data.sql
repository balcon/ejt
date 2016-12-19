INSERT INTO library.authors (name) VALUES ('author1');
INSERT INTO library.authors (name) VALUES ('author2');
INSERT INTO library.authors (name) VALUES ('author3');

INSERT INTO library.books (name, author_id) VALUES ('book1',1);
INSERT INTO library.books (name, author_id) VALUES ('book2',2);
INSERT INTO library.books (name, author_id) VALUES ('book3',3);
INSERT INTO library.books (name, author_id) VALUES ('book4',3);

INSERT INTO library.users (user_id,name,phone) VALUES (0,'John Smith','123-45-67');
INSERT INTO library.users (user_id,name,phone) VALUES (1,'Peter Johnson','234-56-78');
INSERT INTO library.users (user_id,name,phone) VALUES (2,'Roger Young','345-67-89');
INSERT INTO library.users (user_id,name,phone) VALUES (3,'Peter Smith','456-78-90');