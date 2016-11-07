package study.unit5.ex01;

public abstract class Command {

    public static Command createCommand(String[] args) throws CommandException {
        switch (args[0]) {
            case "create":
                return new CommandCreate(args);
            case "read":
                return new CommandRead(args);
            default:
                return null;
        }

    }

    abstract public void execute() throws CommandException;
}
