package study.unit8.ex02.dao;

import study.unit8.ex02.Author;

import java.util.List;

public interface AuthorDao {
    Author create(String name);

    List<Author> getList();

    Author getById(int i);
}
