package study.unit5.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class PropertyReaderTest {
    @Test
    public void readToMap() throws Exception {
        PropertyReader propertyReader0 = new PropertyReader("src\\main\\resources\\study\\unit5\\ex02\\exampe.ini");
        PropertyReader propertyReader = new PropertyReader("src\\main\\resources\\study\\unit5\\ex02\\example.ini");
        propertyReader.seeMap();


    }
}