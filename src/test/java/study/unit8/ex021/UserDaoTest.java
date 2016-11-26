package study.unit8.ex021;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void readFromUserTable() throws Exception {
        UserDao userDao = new UserDao();
        List<User> users=userDao.getUsers();
        assertTrue(!users.isEmpty());
    }
}