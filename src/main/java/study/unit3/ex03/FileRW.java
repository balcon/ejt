package study.unit3.ex03;

import java.io.*;
import java.util.Scanner;

public class FileRW {
    public static String readFrom(String filePath, String codePage) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath), codePage)) {
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append(System.lineSeparator());

            }

        }
        return stringBuilder.toString();
    }
    public static void writeTo(String string, String filePath, String codepage) throws IOException {
        try(PrintWriter pw=new PrintWriter(filePath,codepage)){
            pw.write(string);
        }
    }
}
