package study.unit5.ex01;

import java.io.File;
import java.io.IOException;

public class CommandCreate extends Command {
    String[] args;

    public CommandCreate(String[] args) throws CommandException {
        if (args.length < 2) throw new CommandException("Usage: create <file path> [,file2 path, ...]");
        this.args = args;
    }

    @Override
    public void execute() throws CommandException {
        for (int i = 1; i < args.length; i++) {
            try {
                File file=new File(args[i]);
                file.createNewFile();
            } catch (IOException e) {

                throw new CommandException(String.format("Can't create file [%s]", args[i]));
            }
        }
    }
}
