package study.unit5.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;

public class ReadCommand extends Command {
    String[] args;

    protected ReadCommand(String[] args) throws CommandException {
        if (args.length != 2) throw new CommandException("Usage: read <file path>");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {

        File file = new File(args[1]);
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                stringJoiner.add(scanner.nextLine());
            }
            System.out.print(stringJoiner.toString());
        } catch (FileNotFoundException e) {
            throw new CommandException(String.format("File not found [%s]", args[1]),e);
        }

    }
}
