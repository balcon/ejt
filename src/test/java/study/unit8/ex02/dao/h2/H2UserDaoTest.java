package study.unit8.ex02.dao.h2;

import org.junit.BeforeClass;
import org.junit.Test;
import study.unit8.ex02.User;
import study.unit8.ex02.dao.DaoException;
import study.unit8.ex02.dao.DaoFactory;
import study.unit8.ex02.dao.UserDao;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class H2UserDaoTest extends H2DaoTests {

    @Test
    public void createUser() throws Exception {
        String userName = "UserName";
        User user = userDao.create(userName, "phoneNumber");

        assertEquals(user.getName(), userName);
    }

    @Test
    public void getUserList() throws Exception {
        List<User> users = userDao.getList();
        assertFalse(users.isEmpty());
    }

    @Test
    public void getUserById() throws Exception {
        User user = userDao.getById(1);
        assertEquals(user.getName(), "user1");
    }

    @Test(expected = DaoException.class)
    public void getUserByWrongId() throws Exception {
        userDao.getById(9000);
    }

    @Test
    public void getUserListByName() throws Exception {
        List<User> users = userDao.getListByName("john");
        assertEquals(users.size(), 2);
    }

    @Test(expected = DaoException.class)
    public void removeUser() throws Exception {
        userDao.remove(4);
        userDao.getById(4);
    }

    @Test(expected = DaoException.class)
    public void removeUserByWrongId() throws Exception {
        userDao.remove(9000);
    }

    @Test(expected = DaoException.class)
    public void removeUsedUser() throws Exception {
        userDao.remove(1);
    }
}