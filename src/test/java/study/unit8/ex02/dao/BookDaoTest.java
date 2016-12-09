package study.unit8.ex02.dao;

import org.junit.*;
import study.unit8.ex02.Book;
import study.unit8.ex02.connections.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    public BookDaoTest() throws SQLException, ClassNotFoundException {
    }

    @BeforeClass
    public static void createBookTable() throws Exception {

        try(Connection connection=DaoFactory.getConnection()){
            connection.createStatement().execute(
                    "CREATE TABLE books (" +
                            "book_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                            "name varchar(255) NOT NULL," +
                            "author varchar(255) NOT NULL," +
                            "book_year INT NOT NULL);");
            connection.createStatement().execute("" +
                    "INSERT INTO books (name, author, book_year) VALUES ('book0','author0',2000);");
        }
    }


        BookDao bookDao=DaoFactory.getBookDao();


    @Test
    public void testCreateBook() throws Exception {
        Book book = new Book("book1", "author1", 1950);
        int result = bookDao.createBook(book);
        assertEquals(result,1);
    }

    @Test
    public void testReadAllBooks() throws Exception {
        List<Book> books=bookDao.getBookList();
        assertFalse(books.isEmpty());
    }
}