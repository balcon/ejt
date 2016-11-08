package study.unit5.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public abstract class Command {

    public static Command createCommand(String[] args) throws CommandException {
        switch (args[0]) {
            case "create":
                return new CommandCreate(args);
            case "read":
                return new CommandRead(args);
            case "remove":
                return new CommandRemove(args);
            case "append":
                return new CommandAppend(args);
            default:
                return null;
        }

    }

    abstract public void execute() throws CommandException;

    static protected final String readFile(String filePath) throws FileNotFoundException {
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
