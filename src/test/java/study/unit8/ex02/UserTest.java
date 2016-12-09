package study.unit8.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserConstructor() throws Exception {
        User user = new User("User1", "123-45-67");

        assertEquals("User1",user.getName());
        assertEquals("123-45-67",user.getPhone());
    }
}