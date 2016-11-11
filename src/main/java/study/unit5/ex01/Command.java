package study.unit5.ex01;

import java.io.IOException;

public abstract class Command {

    public static Command createCommand(String[] args) throws CommandException {
        switch (args[0]) {
            case "create":
                return new CreateCommand(args);
            case "read":
                return new ReadCommand(args);
            case "remove":
                return new RemoveCommand(args);
            case "append":
                return new AppendCommand(args);
            case "list":
                return new ListCommand(args);
            default:
                throw new CommandException(String.format("Unknown command [%s]", args[0]));
        }

    }

    abstract public void execute() throws IOException, CommandException;
}
