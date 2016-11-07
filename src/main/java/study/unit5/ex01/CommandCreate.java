package study.unit5.ex01;

import java.io.IOException;

public class CommandCreate extends Command {
    String[] args;

    public CommandCreate(String[] args) throws CommandException {
        if (args.length < 2) throw new CommandException("Usage: create <single file name>");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {
        FileSystem fileSystem = new FileSystem();
        for (int i = 1; i < args.length; i++) {
            try {
                fileSystem.createFile(args[i]);
            } catch (IOException e) {

                throw new CommandException(String.format("Can't create file [%s]", args[i]));
            }
        }
    }
}
