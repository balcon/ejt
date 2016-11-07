package study.unit4.ex02;

import java.io.*;

public class ReaderWriter {
    public static String[] readFrom(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String data = reader.readLine();
            while (data != null) {
                stringBuilder.append(data);
                stringBuilder.append(System.lineSeparator());
                data = reader.readLine();
            }
        }
        return stringBuilder.toString().split("[\\s{}()./*\\[\\];!=\\\"]+");
    }

    static void writeTo(String string, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(string);
        }
    }
}
