package study.unit8.ex02.dao.h2;

import org.junit.BeforeClass;
import org.junit.Test;
import study.unit8.ex02.User;
import study.unit8.ex02.dao.DaoFactory;
import study.unit8.ex02.dao.UserDao;

import java.util.List;

import static org.junit.Assert.*;

public class H2UserDaoTest extends H2DaoTests{

    private static UserDao userDao;

    @BeforeClass
    public static void setUp() throws Exception {
        DaoFactory daoFactory=new H2DaoFactory(H2DaoTests.connectionPool);
        userDao = daoFactory.getUserDao();
    }

    @Test
    public void createUser() throws Exception {
        User user = new User(100, "Anonymous", "345-67-89");
        int result = userDao.create(user);
        assertEquals(result, 1);
    }

    @Test
    public void getUserList() throws Exception {
        List<User> users = userDao.getList();
        assertFalse(users.isEmpty());
    }

    @Test
    public void getUserById() throws Exception {
        User user = userDao.getById(0);
        assertEquals(user.getName(), "John Smith");
    }

    @Test(expected = RuntimeException.class)
    public void getUserByWrongId() throws Exception {
        userDao.getById(9000);
    }

    @Test
    public void getUserListByName() throws Exception {
        List<User> users = userDao.getListByName("john");
        assertEquals(users.size(), 2);
    }

    @Test(expected = RuntimeException.class)
    public void removeUserById() throws Exception {
        userDao.remove(4);
        userDao.getById(4);
    }

    @Test(expected = RuntimeException.class)
    public void removeUserByWrongId() throws Exception {
        userDao.remove(9000);
    }
}