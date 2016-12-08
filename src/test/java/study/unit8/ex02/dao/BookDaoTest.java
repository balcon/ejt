package study.unit8.ex02.dao;

import org.junit.*;
import study.unit8.ex02.Book;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    @BeforeClass
    public static void createBookTable() throws Exception {
        try(Connection connection=DaoFactory.getConnection()){
            connection.createStatement().execute(
                    "CREATE TABLE books (" +
                            "book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                            "name varchar(255) NOT NULL," +
                            "author varchar(255) NOT NULL," +
                            "book_year INT NOT NULL);");
        }
    }

    BookDao bookDao=DaoFactory.getBookDao();

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book("Foundation", "Isaac Asimov", 1951);
        int result = bookDao.createBook(book);
        assertEquals(result,1);
    }

    @Test
    public void testReadAllBooks() throws Exception {
        Book book = new Book("Dune", "Frank Herbert", 1965);
        int result = bookDao.createBook(book);
        List<Book> books=bookDao.getBookList();
        assertFalse(books.isEmpty());
    }
}