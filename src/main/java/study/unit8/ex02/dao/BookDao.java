package study.unit8.ex02.dao;

import study.unit8.ex02.Author;
import study.unit8.ex02.Book;

import java.util.List;

public interface BookDao {
    Book create(String name, Author author);

    Book create(String name, List<Author> authors);

    List<Book> getList();

    List<Book> getListByAuthor(Author author);

    List<Book> getListByName(String name);

    Book getById(int id);

    void removeById(int id);
}
