package study.unit8.ex02.dao;

import org.junit.Before;
import org.junit.Test;
import study.unit8.ex02.Book;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookDaoTest extends AbstractDaoTest {
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        bookDao = DaoFactory.getBookDao();
    }

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(2, "book2", "author2", 1950);
        int result = bookDao.createBook(book);
        assertEquals(result, 1);
    }

    @Test
    public void getBooksList() throws Exception {
        List<Book> books = bookDao.getBookList();
        assertFalse(books.isEmpty());
    }

    @Test
    public void getRentedBooksByUser() throws Exception {

        // List<Book> books = bookDao.getRentedBooksByUser(new);
    }
}