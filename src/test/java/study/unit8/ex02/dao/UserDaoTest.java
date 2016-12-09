package study.unit8.ex02.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import study.unit8.ex02.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserDaoTest {
    public UserDaoTest() throws SQLException, ClassNotFoundException {
    }

    @BeforeClass
    public static void createUserTable() throws Exception {
        try (Connection connection = DaoFactory.getConnection()) {
            connection.createStatement().execute(
                    "CREATE TABLE users (" +
                            "user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                            "name varchar(255) NOT NULL," +
                            "phone varchar(20) NOT NULL);");
            connection.createStatement().execute(
                    "INSERT INTO users (name,phone) VALUES ('User0','123-45-67');");
        }
    }

    UserDao userDao = DaoFactory.getUserDao();

    @Test
    public void testCreateUser() throws Exception {
        User user = new User("user1", "123-45-67");
        int result = userDao.createUser(user);
        assertEquals(result, 1);
    }

    @Test
    public void getUserList() throws Exception {
        List<User> users = userDao.getUserList();
        assertFalse(users.isEmpty());
    }






}