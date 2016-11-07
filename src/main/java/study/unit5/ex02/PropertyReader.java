package study.unit5.ex02;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {
    private final Map<String, String> keys = new HashMap<>();

    public PropertyReader(String filePath) {
        readProperty(filePath);
    }

    private void readProperty(String filePath) {
        try {
            Properties property = new Properties();
            property.load(new FileReader(filePath));
            for (String entry : property.stringPropertyNames()) {
                keys.put(entry, property.getProperty(entry));
            }
        } catch (IOException e) {
            System.out.println("Error R/W file [" + filePath + "]");
        }
    }

    public void seeMap() {
        System.out.println(keys.toString());
    }
}
