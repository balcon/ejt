package study.unit8.ex02.dao;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import study.unit8.ex02.User;

import java.sql.Connection;

import static org.junit.Assert.*;

public class UserDaoTest {
    @BeforeClass
    public static void createUserTable() throws Exception {
        try(Connection connection=DaoFactory.getConnection()) {
            connection.createStatement().execute(
                    "CREATE TABLE users (" +
                            "user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                            "name varchar(255) NOT NULL," +
                            "phone varchar(20) NOT NULL);");
        }
    }

    UserDao userDao=DaoFactory.getUserDao();

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("Piter Johnson", "123-45-67");

    }

}