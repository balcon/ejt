package study.unit8.ex02.dao.h2;

import org.junit.Before;
import org.junit.Test;
import study.unit8.ex02.Author;
import study.unit8.ex02.Book;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class H2BookDaoTest extends H2DaoTests {

    @Test
    public void createBookWithSingleAuthor() throws Exception {
        Author author = authorDao.getById(2);
        String bookName = "Name1";

        Book book = bookDao.create(bookName,author);

        assertEquals(book.getName(), bookName);
        assertEquals(book.getAuthors().get(0).getId(),2);
    }

    @Test
    public void createBookWithManyAuthors() throws Exception {
        List<Author> authors = new ArrayList<>();
        authors.add(authorDao.getById(1));
        authors.add(authorDao.getById(2));
        String bookName = "Name2";

        Book book=bookDao.create(bookName,authors);

        assertEquals(book.getName(),bookName);
        assertEquals(book.getAuthors().size(),2);

    }

    @Test
    public void getBooksList() throws Exception {
        List<Book> books = bookDao.getList();

        assertFalse(books.isEmpty());
        assertTrue(books.get(0).getAuthors().size()>0);
    }

    @Test
    public void getBookById() throws Exception {
        Book book = bookDao.getById(1);

        assertEquals(book.getName(), "book1");
        assertEquals(book.getAuthors().size(),3);
    }

    @Test
    public void getBookListByAuthor() throws Exception {
        Author author=authorDao.getById(3);
        List<Book> books=bookDao.getListByAuthor(author);

        assertEquals(books.size(),2);
    }

    @Test
    public void getBookListByName() throws Exception {
        List<Book> manyBooks=bookDao.getListByName("book");
        List<Book> singleBook = bookDao.getListByName("book1");
        List<Book> emptyList = bookDao.getListByName("noName");

        assertEquals(manyBooks.size(),4);
        assertEquals(singleBook.size(),1);
        assertTrue(emptyList.isEmpty());
    }
}
