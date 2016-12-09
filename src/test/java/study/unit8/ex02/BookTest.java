package study.unit8.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookConstructor() throws Exception {
        Book book = new Book("book1", "author1", 1950);

        assertEquals("book1",book.getName());
        assertEquals("author1",book.getAuthor());
        assertEquals(1950,book.getYear());
    }
}