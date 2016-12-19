package study.unit8.ex02.dao.h2;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import study.unit8.ex02.Author;
import study.unit8.ex02.Book;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class H2BookDaoTest extends H2DaoTests {
    private BookDao bookDao;
    private AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
        DaoFactory daoFactory = new H2DaoFactory(H2DaoTests.connectionPool);
        bookDao = daoFactory.getBookDao();
        authorDao = daoFactory.getAuthorDao();
    }

    @Test
    public void createBook() throws Exception {
        String bookName = "BookName";
        Author author = authorDao.getById(1);
        ;
        Book book = bookDao.create(bookName, author);

        assertEquals(book.getName(), bookName);
    }

    @Test
    public void getBooksList() throws Exception {
        List<Book> books = bookDao.getList();
        assertFalse(books.isEmpty());
    }

    @Test
    public void getBookById() throws Exception {
        Book book = bookDao.getById(1);

        assertEquals(book.getName(), "book1");
    }
}