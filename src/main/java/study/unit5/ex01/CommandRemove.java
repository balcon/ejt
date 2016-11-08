package study.unit5.ex01;

import java.io.File;

public class CommandRemove extends Command {
    String[] args;

    public CommandRemove(String[] args) throws CommandException {
        if (args.length < 2) throw new CommandException("Usage: remove <file path> [,file2 path, ...]");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {
        for (int i = 1; i < args.length; i++) {

            File file = new File(args[i]);
            if (file.isDirectory()) {
                throw new CommandException("Can't remove directories");
            } else
                file.delete();
        }
    }
}
