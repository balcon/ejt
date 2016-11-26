package study.unit8.ex021;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BookDaoTest {

    @Test
    public void readFromTableBooks() throws Exception {
        BookDao bookDao = new BookDao();
        List<Book> books = bookDao.getBooks();
        assertTrue(!books.isEmpty());
    }

    @Test
    @Ignore
    public void createBook() throws Exception {
        BookDao bookDao = new BookDao();
        List<Book> books = new ArrayList<>();
        books.add(new Book(10, "BookX", "AuthorX", null));
        assertTrue(bookDao.createBooks(books) > 0);
    }

}