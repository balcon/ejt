package study.unit8.ex02.dao.h2;

import org.junit.Test;
import study.unit8.ex02.Author;

import java.util.List;

import static org.junit.Assert.*;

public class H2AuthorDaoTest extends H2DaoTests {

    @Test
    public void createAuthor() throws Exception {
        String authorName = "Name";
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

    @Test
    public void getAuthorsListByName() throws Exception {
        List<Author> manyAuthors = authorDao.getListByName("author");
        List<Author> singleAuthor = authorDao.getListByName("author3");
        List<Author> emptyList = authorDao.getListByName("John");

        assertEquals(manyAuthors.size(), 3);
        assertEquals(singleAuthor.size(), 1);
        assertTrue(emptyList.isEmpty());
    }
}