package study.unit8.ex02.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import study.unit8.ex02.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserDaoTest {
    public UserDaoTest() throws SQLException, ClassNotFoundException {
    }

    @BeforeClass
    public static void createUserTable() throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")) {
            connection.createStatement().execute(
                    "CREATE TABLE users (" +
                            "user_id INT NOT NULL PRIMARY KEY," +
                            "name varchar(255) NOT NULL," +
                            "phone varchar(20) NOT NULL);");
            connection.createStatement().execute(
                    "INSERT INTO users (user_id,name,phone) VALUES (0,'User0','123-45-67');" +
                            "INSERT INTO users (user_id,name,phone) VALUES (1,'User1','234-56-78');");
        }
    }

    UserDao userDao = DaoFactory.getUserDao();

    @Test
    public void testCreateUser() throws Exception {
        User user = new User(2, "Anonymous", "345-67-89");
        int result = userDao.createUser(user);
        assertEquals(result, 1);
    }

    @Test
    public void getUserList() throws Exception {
        List<User> users = userDao.getUserList();
        assertFalse(users.isEmpty());
    }

    @Test
    public void getUserById() throws Exception {
        User user=userDao.getById(0);
        assertEquals(user.getName(),"User0");
    }

    @Test(expected = RuntimeException.class)
    public void getUserByWrongId() throws Exception {
        userDao.getById(9000);
    }

    @Test
    public void getUserListByName() throws Exception {
        List<User> users=userDao.getByName("user");
        assertEquals(users.size(),2);
    }
}