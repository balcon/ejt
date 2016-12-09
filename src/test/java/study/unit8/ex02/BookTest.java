package study.unit8.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookConstructor() throws Exception {
        Book book = new Book(1,"book1", "author1", 1950);

        assertEquals(book.getId(),1);
        assertEquals(book.getName(),"book1");
        assertEquals(book.getAuthor(),"author1");
        assertEquals(book.getYear(),1950);
    }
}