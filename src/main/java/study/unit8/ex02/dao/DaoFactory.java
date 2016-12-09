package study.unit8.ex02.dao;

import study.unit8.ex02.connections.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    public static BookDao getBookDao() throws SQLException, ClassNotFoundException {
        return new BookDao(new ConnectionPool());
    }

    public static UserDao getUserDao() throws SQLException, ClassNotFoundException {
        return new UserDao(new ConnectionPool());
    }
}
