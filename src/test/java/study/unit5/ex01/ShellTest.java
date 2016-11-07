package study.unit5.ex01;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ShellTest {

    private ByteArrayOutputStream output = redefineSystemOutput();

    private ByteArrayOutputStream redefineSystemOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    @Test
    public void shellCreate() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\shellCreateTestFile.txt";
        Shell.main("create", filePath);
        assertTrue(new File(filePath).exists());
    }

    @Test
    public void shellCreateWithoutFileNameParameter() throws Exception {
        Shell.main("create");
        assertTrue(terminalMessage().equals("Usage: create <single file name>"));
    }

    @Test
    public void shellCreateManyFiles() throws Exception {
        String directory = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\";
        Shell.main("create", directory + "createFile1", directory + "createFile2");

        assertTrue(new File(directory + "createFile1").exists());
        assertTrue(new File(directory + "createFile2").exists());
    }

    @Test
    public void shellReadFile() throws Exception {
        Shell.main("read", "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\readFileTest.txt");

        assertTrue(terminalMessage().equals("test string"));
    }

    private String terminalMessage() {
        return output.toString();
    }

    private void debug() {
        System.err.println(terminalMessage());
    }

    @Test
    public void shellReadWithoutFileNameParameter() throws Exception {
        Shell.main("read");

        assertTrue(terminalMessage().equals("Usage: read <single file name>"));
    }

    @Test
    public void shellReadWithSuperfluousParameter() throws Exception {
        Shell.main("read", "//path/to/file", "//path/to/file");

        assertTrue(terminalMessage().equals("Usage: read <single file name>"));
    }

    @Test
    public void shellReadUnexistentFile() throws Exception {
        String filePath = "\\anyDirectory\\anyFile.txt";
        Shell.main("read", filePath);

        assertTrue(terminalMessage().equals(String.format("File not found [%s]", filePath)));
    }
}
