package study.unit8.ex02.dao.h2;

import org.junit.Test;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;
import study.unit8.ex02.dao.UserDao;

import static org.junit.Assert.*;

public class H2DaoFactoryTest {

    private DaoFactory daoFactory = new H2DaoFactory(H2DaoTests.connectionPool);

    @Test
    public void getBookDao() throws Exception {
        BookDao bookDao=daoFactory.getBookDao();

        assertTrue(bookDao instanceof H2BookDao);
    }

    @Test
    public void getUserDao() throws Exception {
        UserDao userDao=daoFactory.getUserDao();

        assertTrue(userDao instanceof H2UserDao);
    }

    @Test
    public void getAuthorDao() throws Exception {
        AuthorDao authorDao=daoFactory.getAuthorDao();

        assertTrue(authorDao instanceof H2AuthorDao);
    }
}