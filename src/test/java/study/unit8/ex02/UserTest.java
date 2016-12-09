package study.unit8.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserConstructor() throws Exception {
        User user = new User(1, "User1", "123-45-67");

        assertEquals(user.getId(),1);
        assertEquals(user.getName(),"User1");
        assertEquals(user.getPhone(),"123-45-67");
    }
}