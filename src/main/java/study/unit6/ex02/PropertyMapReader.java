package study.unit6.ex02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyMapReader {
    private final Map<String,String> mapStorage=new HashMap<>();

    public PropertyMapReader(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath)) {
            Properties properties = new Properties();
            properties.load(fileReader);
            for (String key : properties.stringPropertyNames()) {
                mapStorage.put(key,properties.getProperty(key));
            }
        }
    }

    public int getSize() {
        return mapStorage.size();
    }

    public String getValue(String key) {
        return mapStorage.get(key);
    }
}
