package study.unit5.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ListCommand extends Command {
    private final String[] args;

    public ListCommand(String[] args) throws CommandException {
        if(args.length!=2) throw new CommandException("Usage: list <path to directory>");
        this.args=args;
    }

    @Override
    public void execute() throws CommandException, FileNotFoundException {
        File file = new File(args[1]);
        if (!file.exists()) {
            throw new FileNotFoundException(String.format("Directory not found [%s]", args[1]));
        } else if (!file.isDirectory()) {
            throw new CommandException(String.format("[%s] is not directory", args[1]));
        } else {
            for (String fileName : file.list()) {
                System.out.println(fileName);
            }
        }
    }
}
