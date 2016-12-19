package study.unit8.ex02.dao;

import study.unit8.ex02.Author;
import study.unit8.ex02.Book;

import java.util.List;

public interface BookDao {
    Book create(String name, Author author);
    List<Book> getList();
    Book getById(int id);
}
