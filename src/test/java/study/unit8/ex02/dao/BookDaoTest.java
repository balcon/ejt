package study.unit8.ex02.dao;

import org.junit.BeforeClass;
import org.junit.Test;
import study.unit8.ex02.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BookDaoTest {
    public BookDaoTest() throws SQLException, ClassNotFoundException {
    }

    @BeforeClass
    public static void createBookTable() throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1")) {
            connection.createStatement().execute(
                    "CREATE TABLE books (" +
                            "book_id INT NOT NULL PRIMARY KEY," +
                            "name varchar(255) NOT NULL," +
                            "author varchar(255) NOT NULL," +
                            "book_year INT NOT NULL);");
            connection.createStatement().execute("" +
                    "INSERT INTO books (book_id,name, author, book_year) VALUES (0,'book0','author0',2000);");
        }
    }


    BookDao bookDao = DaoFactory.getBookDao();

    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book(1,"book1", "author1", 1950);
        int result = bookDao.createBook(book);
        assertEquals(result, 1);
    }

    @Test
    public void testReadAllBooks() throws Exception {
        List<Book> books = bookDao.getBookList();
        assertFalse(books.isEmpty());
    }
}