package study.unit5.ex02;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class PropertyReaderTest {
    String filePath = "src\\main\\resources\\study\\unit5\\ex02\\example.properties";

    @Test
    public void getExistingValue() throws Exception {
        PropertyReader propertyReader = new PropertyReader(filePath, "db.user");

        assertEquals(propertyReader.getValue(), "sa");
    }

    @Test(expected = FileNotFoundException.class)
    public void readWithWrongFilePath() throws Exception {
        String filePath = "c:\\ghostfile.properties";
            PropertyReader propertyReader = new PropertyReader(filePath, "db.user");
    }

    @Test(expected = KeyNotFoundException.class)
    public void readWithWrongKey() throws Exception {
            PropertyReader propertyReader = new PropertyReader(filePath, "db.wrong");
    }
}