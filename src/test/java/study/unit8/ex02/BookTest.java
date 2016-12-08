package study.unit8.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void testBookConstructor() throws Exception {
        Book book = new Book("Foundation", "Isaac Asimov", 1951);

        assertEquals("Foundation",book.getName());
        assertEquals("Isaac Asimov",book.getAuthor());
        assertEquals(1951,book.getYear());
    }
}