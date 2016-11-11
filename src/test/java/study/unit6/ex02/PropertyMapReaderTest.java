package study.unit6.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyMapReaderTest {
    String filePath="src\\main\\resources\\study\\unit5\\ex02\\example.properties";

    @Test
    public void testReadPropertyFile() throws Exception {

        PropertyMapReader propertyMapReader = new PropertyMapReader(filePath);

        assertEquals(propertyMapReader.getSize(),5);
    }

    @Test
    public void testGetValue() throws Exception {

        PropertyMapReader propertyMapReader = new PropertyMapReader(filePath);

        assertEquals(propertyMapReader.getValue("db.user"),"sa");

    }
}