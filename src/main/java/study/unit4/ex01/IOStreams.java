package study.unit4.ex01;

import java.io.*;

public class IOStreams {

    public static String[] readFrom(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            int data = inputStream.read();
            while (data != -1) {
                stringBuilder.append((char) data);
                data = inputStream.read();
            }
        }

        return stringBuilder.toString().split("[\\s{}()./*\\[\\];!=\\\"]+");
    }

    public static void writeTo(String string, String filePath) throws IOException {
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath))) {
            outputStream.write(string.getBytes());
         }
    }
}
