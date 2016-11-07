package study.unit5.ex01;

public class Shell {
    public static void main(String... args) {
        Command command = null;
        try {
            command = Command.createCommand(args);
            command.execute();
        } catch (CommandException e) {
            System.out.print(e.getMessage());
        }
    }
}
