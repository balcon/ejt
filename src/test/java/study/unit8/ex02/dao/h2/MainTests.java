package study.unit8.ex02.dao.h2;

import org.junit.Test;
import study.unit8.ex02.Author;
import study.unit8.ex02.Book;
import study.unit8.ex02.connections.ConnectionPool;
import study.unit8.ex02.dao.AuthorDao;
import study.unit8.ex02.dao.BookDao;
import study.unit8.ex02.dao.DaoFactory;

import java.util.ArrayList;
import java.util.List;

public class MainTests extends H2DaoTests{
    @Test
    public void mainTest() throws Exception {
        System.out.println("all authors:");
        for (Author author : authorDao.getList()) {
            System.out.println(author);
        }

        System.out.println("\nall books:");
        for (Book book : bookDao.getList()) {
            System.out.println(book);
        }

        System.out.println("\nall books of author2:");
        for (Book book : bookDao.getListByAuthor(authorDao.getById(2))) {
            System.out.println(book);
        }

        System.out.println("\nall boks with name \"boo\":");
        for (Book book : bookDao.getListByName("boo")) {
            System.out.println(book);
        }

        System.out.println("\nadd new authors:");
        Author author1=authorDao.create("Bill");
        System.out.println(author1);
        Author author2=authorDao.create("John");
        System.out.println(author2);

        System.out.println("\nadd new books:");
        Book book1=bookDao.create("Bill's life",author1);
        System.out.println(book1);
        List<Author> authors=new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
        Book book2=bookDao.create("Novels",authors);
        System.out.println(book2);


    }
}
