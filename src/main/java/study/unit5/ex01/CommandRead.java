package study.unit5.ex01;

import java.io.FileNotFoundException;

public class CommandRead extends Command {
    String[] args;

    protected CommandRead(String[] args) throws CommandException {
        if (args.length != 2) throw new CommandException("Usage: read <single file name>");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {
        FileSystem fileSystem = new FileSystem();
        try {
            System.out.print(fileSystem.readFile(args[1]));
        } catch (FileNotFoundException e) {
            throw new CommandException(String.format("File not found [%s]", args[1]));

        }
    }

    @Override
    public boolean invalidParameters() {
        return args.length != 2;
    }

    @Override
    public String getErrorMessage() {
        return "Usage: read <single file name>";
    }
}
