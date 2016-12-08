package study.unit8.ex02.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }

    public static BookDao getBookDao() {
        return new BookDao();
    }

    public static UserDao getUserDao() {
        return new UserDao();
    }
}
