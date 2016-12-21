package study.unit8.ex02.dao.h2;

import org.junit.Test;
import study.unit8.ex02.Author;
import study.unit8.ex02.Book;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;

import java.util.List;

public class MainTests extends H2DaoTests{
    @Test
    public void mainTest() throws Exception {
        System.out.println("all authors:");
        for (Author author : authorDao.getList()) {
            System.out.println(author);
        }
        System.out.println("all books:");
        for (Book book : bookDao.getList()) {
            System.out.println(book);
        }
        System.out.println("all books of author2:");
        for (Book book : bookDao.getListByAuthor(authorDao.getById(2))) {
            System.out.println(book);
        }
    }
}
