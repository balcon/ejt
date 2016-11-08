package study.unit5.ex01;

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
            default:
                return null;
        }

    }

    abstract public void execute() throws CommandException;
}
