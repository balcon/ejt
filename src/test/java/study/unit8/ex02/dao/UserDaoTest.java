package study.unit8.ex02.dao;

import org.junit.Before;
import org.junit.Test;
import study.unit8.ex02.User;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserDaoTest extends AbstractDaoTest {

    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userDao = DaoFactory.getUserDao();
    }

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
        User user = userDao.getById(0);
        assertEquals(user.getName(), "User0");
    }

    @Test(expected = RuntimeException.class)
    public void getUserByWrongId() throws Exception {
        userDao.getById(9000);
    }

    @Test
    public void getUserListByName() throws Exception {
        List<User> users = userDao.getUsersByName("user");
        System.out.println(users);
        assertEquals(users.size(), 2);
    }

    @Test(expected = RuntimeException.class)
    public void removeUserById() throws Exception {
        userDao.removeUser(1);
        userDao.getById(1);
    }

    @Test(expected = RuntimeException.class)
    public void removeUserByWrongId() throws Exception {
        userDao.removeUser(9000);
    }
}