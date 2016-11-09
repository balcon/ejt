package study.unit5.ex02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private String value = "";

    public PropertyReader(String filePath, String key) throws IOException {
        readValue(filePath, key);
    }

    private void readValue(String filePath, String key) throws IOException {
        Properties property = new Properties();
        try (FileReader fileReader = new FileReader(filePath)) {
            property.load(fileReader);
            if (!property.containsKey(key)) {
                throw new KeyNotFoundException(String.format("Unavailable key [%s]", key));
            } else {
                value = property.getProperty(key);
            }
        }
        catch (FileNotFoundException e){
            throw new FileNotFoundException(String.format("File not found [%s]",filePath));
        }


    }

    public String getValue() {
        return value;
    }
}
