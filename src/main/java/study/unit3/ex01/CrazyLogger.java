package study.unit3.ex01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CrazyLogger {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm");
    private final StringBuilder logStorage;

    public CrazyLogger() {
        logStorage = new StringBuilder();
    }

    public void log(String message) {
        logStorage.append(LocalDateTime.now().format(formatter));
        logStorage.append(" - ");
        logStorage.append(message);
        logStorage.append(System.lineSeparator());
    }

    public void printLog() {
        System.out.println(logStorage.toString());
    }

    public void findLog(String searchString) {
        StringBuilder searchResult = new StringBuilder();
        try (Scanner scanner = new Scanner(logStorage.toString())) {
            while (scanner.hasNextLine()) {
                String currentString = scanner.nextLine();
                if (currentString.contains(searchString)) {
                    searchResult.append(currentString);
                    searchResult.append(System.lineSeparator());
                }
            }
        }
        System.out.println("Search result for \"" + searchString + "\":");
        System.out.println(searchResult.toString());
    }
}
