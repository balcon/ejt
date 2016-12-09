package study.unit8.ex02.dao;

import study.unit8.ex02.connections.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
       return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }

    public static BookDao getBookDao() throws SQLException, ClassNotFoundException {
        return new BookDao(new ConnectionPool());
    }

    public static UserDao getUserDao() throws SQLException, ClassNotFoundException {
        return new UserDao(new ConnectionPool());
    }
}
