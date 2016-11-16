package study.unit5.ex02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private final Properties properties;

    public PropertyReader(String filePath) throws IOException {
        properties = new Properties();
        try (FileReader fileReader = new FileReader(filePath)) {
            properties.load(fileReader);
        }
    }

    public String getValue(String key) throws KeyNotFoundException {
        if (!properties.containsKey(key)) {
            throw new KeyNotFoundException(String.format("Unavailable key [%s]", key));
        } else {
            return properties.getProperty(key);
        }
    }
}
