package study.unit5.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringJoiner;

public class FileSystem {
    public void createFile(String filePath) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
    }

    public String readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringJoiner.add(scanner.nextLine());
            }

        }
        return stringJoiner.toString();
    }
}
