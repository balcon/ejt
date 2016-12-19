package study.unit8.ex02.dao.h2;

import org.junit.Before;
import org.junit.Test;
import study.unit8.ex02.Author;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.DaoFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class H2AuthorDaoTest extends H2DaoTests {

    private AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        DaoFactory daoFactory = new H2DaoFactory(H2DaoTests.connectionPool);
        authorDao = daoFactory.getAuthorDao();
    }

    @Test
    public void createAuthorTest() throws Exception {
        String authorName = "AuthorName";
        Author author = authorDao.create(authorName);

        assertEquals(author.getName(), authorName);
    }

    @Test
    public void getAuthorsList() throws Exception {
        List<Author> authors;
        authors = authorDao.getList();

        assertFalse(authors.isEmpty());
    }

    @Test
    public void getAuthorById() throws Exception {
        Author author = authorDao.getById(1);

        assertEquals(author.getName(), "author1");
    }
}