package study.unit8.ex02.dao;

import study.unit8.ex02.User;

import java.util.List;

public interface UserDao {
    int create(User user);

    List<User> getList();

    User getById(int id);

    List<User> getListByName(String userName);

    void remove(int id);
}
