package study.unit8.ex02.dao;

import study.unit8.ex02.User;

import java.util.List;

public interface UserDao {
    User create(String name, String phone);

    List<User> getList();

    User getById(int id);

    List<User> getListByName(String userName);

    void remove(int id);
}
