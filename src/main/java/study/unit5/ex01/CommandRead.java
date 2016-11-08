package study.unit5.ex01;

import java.io.FileNotFoundException;

public class CommandRead extends Command {
    String[] args;

    protected CommandRead(String[] args) throws CommandException {
        if (args.length != 2) throw new CommandException("Usage: read <file path>");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {
        try {
            System.out.print(Command.readFile(args[1]));
        } catch (FileNotFoundException e) {
            throw new CommandException(String.format("Can't read file [%s]", args[1]));

        }
    }
}
