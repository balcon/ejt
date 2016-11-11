package study.unit5.ex01;

import java.io.IOException;

public class Shell {
    public static void main(String... args) throws IOException, CommandException {
        Command command = null;
        try {
            command = Command.createCommand(args);
            command.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
