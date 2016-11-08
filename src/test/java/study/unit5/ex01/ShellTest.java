package study.unit5.ex01;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class ShellTest {

    private ByteArrayOutputStream output = redefineSystemOutput();

    private ByteArrayOutputStream redefineSystemOutput() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    private void createNewTempFile(String filePath, String content) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            printWriter.write(content);
        }
    }

    private String terminalMessage() {
        return output.toString();
    }

    private void debug() {
        System.err.println(terminalMessage());
    }


    @Test
    public void createFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\createTestFile.txt";
        Shell.main("create", filePath);
        assertTrue(new File(filePath).exists());
    }

    @Test
    public void createFileWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\GhostDirectory\\createTestFile.txt";
        Shell.main("create", filePath);
        assertEquals(terminalMessage(), String.format("Can't create file [%s]", filePath));
    }

    @Test
    public void createWithoutFileNameParameter() throws Exception {
        Shell.main("create");
        assertTrue(terminalMessage().equals("Usage: create <file path> [,file2 path, ...]"));
    }

    @Test
    public void createManyFiles() throws Exception {
        String directory = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\";
        Shell.main("create", directory + "createFile1.txt", directory + "createFile2.txt");

        assertTrue(new File(directory + "createFile1.txt").exists());
        assertTrue(new File(directory + "createFile2.txt").exists());
    }


    @Test
    public void readFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\readFileTest.txt";
        createNewTempFile(filePath, "test string");

        Shell.main("read", filePath);

        assertTrue(terminalMessage().equals("test string"));
    }

    @Test
    public void readFileWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\blahblahblah.txt";
        Shell.main("read", filePath);
        assertEquals(terminalMessage(), String.format("Can't read file [%s]", filePath));
    }

    @Test
    public void readWithoutFileNameParameter() throws Exception {
        Shell.main("read");

        assertTrue(terminalMessage().equals("Usage: read <file path>"));
    }

    @Test
    public void readWithSuperfluousParameter() throws Exception {
        Shell.main("read", "//path/to/file", "//path/to/file");

        assertTrue(terminalMessage().equals("Usage: read <file path>"));
    }


    @Test
    public void removeFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\removeFileTest.txt";
        createNewTempFile(filePath, "");

        assertTrue(new File(filePath).exists());

        Shell.main("remove", filePath);

        assertFalse(new File(filePath).exists());

    }

    @Test
    public void removeFileWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\blahblahblah.txt";
        Shell.main("remove", filePath);
        assertEquals(terminalMessage(),String.format("Can't remove file [%s]",filePath));
    }

    @Test
    public void removeManyFiles() throws Exception {
        String filePath1 = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\removeFileTest1.txt";
        String filePath2 = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\removeFileTest2.txt";
        createNewTempFile(filePath1, "");
        createNewTempFile(filePath2, "");

        Shell.main("remove", filePath1, filePath2);

        assertFalse(new File(filePath1).exists());
        assertFalse(new File(filePath2).exists());
    }

    @Test
    public void removeDirectory() throws Exception {
        Shell.main("remove", "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target");

        assertEquals(terminalMessage(), "Can't remove directories");
    }

    @Test
    public void removeWihoutFileNameParametr() throws Exception {
        Shell.main("remove");

        assertEquals(terminalMessage(), "Usage: remove <file path> [,file2 path, ...]");
    }

    @Test
    public void appendToFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\appendFileTest.txt";
        createNewTempFile(filePath, "Test text");

        Shell.main("append", filePath, "appended", "text");
        Shell.main("read", filePath);

        assertEquals(terminalMessage(), "Test text appended text");
    }
}
