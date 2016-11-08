package study.unit5.ex01;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class CommandAppend extends Command {
    private final String[] args;

    public CommandAppend(String[] args) throws CommandException {
        if (args.length < 3) throw new CommandException("Usage: append <file path> <appended string>");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {
        StringJoiner appendedText=new StringJoiner(" ");
        for (int i = 2; i < args.length; i++) {
            appendedText.add(args[i]);
        }
        String fileContent = "";
        try {
            fileContent = Command.readFile(args[1]);

            try (PrintWriter printWriter = new PrintWriter(args[1])) {
                printWriter.write(fileContent +" "+ appendedText.toString());
            }
        } catch (FileNotFoundException e) {
            throw new CommandException(String.format("Can't append to file [%s]", args[1]));
        }
    }
}
