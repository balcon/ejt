package study.unit5.ex01;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class AppendCommand extends Command {
    private final String[] args;

    public AppendCommand(String[] args) throws CommandException {
        if (args.length < 3) throw new CommandException("Usage: append <file path> <appended string>");
        this.args = args;
    }

    @Override
    public void execute() throws IOException {
        StringJoiner appendedText = new StringJoiner(" ");
        for (int i = 2; i < args.length; i++) {
            appendedText.add(args[i]);
        }
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(args[1], true))) {
            printWriter.write(" " + appendedText.toString());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(String.format("File not found [%s]", args[1]));
        } catch (IOException e) {
            throw new IOException(String.format("Can't append to file [%s]", args[1]));
        }
    }
}
