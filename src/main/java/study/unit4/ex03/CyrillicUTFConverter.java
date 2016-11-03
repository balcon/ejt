package study.unit4.ex03;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CyrillicUTFConverter {
    public static void main(String[] args) {
        String sourcePath = "src\\main\\resources\\study\\unit4\\ex03\\source_utf-8.txt";
        String resultPath = "src\\main\\resources\\study\\unit4\\ex03\\result_utf-16.txt";

        try (Scanner scanner = new Scanner(new File(sourcePath), "utf8");
             PrintWriter printWriter = new PrintWriter(resultPath, "utf-16")) {

            while (scanner.hasNext()) {
                printWriter.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
