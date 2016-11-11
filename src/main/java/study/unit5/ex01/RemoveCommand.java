package study.unit5.ex01;

import java.io.File;
import java.io.FileNotFoundException;

public class RemoveCommand extends Command {
    private final String[] args;

    public RemoveCommand(String[] args) throws CommandException {
        if (args.length < 2) throw new CommandException("Usage: remove <file path> [,file2 path, ...]");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException, FileNotFoundException {
        for (int i = 1; i < args.length; i++) {

            File file = new File(args[i]);
            if (!file.exists()) {
                throw new FileNotFoundException(String.format("File not found [%s]", args[1]));
            } else if (file.isDirectory()) {
                throw new CommandException("Can't remove directories");
            } else if (!file.delete()) {
                throw new CommandException(String.format("Can't remove file [%s]", args[i]));
            }
        }

    }
}
