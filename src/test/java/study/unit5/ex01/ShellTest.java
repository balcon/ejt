package study.unit5.ex01;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShellTest {

    private ByteArrayOutputStream systemOutput = redefineSystemOutput();

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


    @Test
    public void createFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\createTestFile.txt";
        Shell.main("create", filePath);
        assertTrue(new File(filePath).exists());
    }

    @Test(expected = IOException.class)
    public void createFileWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\GhostDirectory\\createTestFile.txt";
        Shell.main("create", filePath);
    }

    @Test(expected = CommandException.class)
    public void createWithoutFileNameParameter() throws Exception {
        Shell.main("create");
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

        assertTrue(systemOutput.toString().contains("test string"));
    }

    @Test(expected = FileNotFoundException.class)
    public void readFileWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\blahblahblah.txt";
        Shell.main("read", filePath);
    }

    @Test(expected = CommandException.class)
    public void readWithoutFileNameParameter() throws Exception {
        Shell.main("read");
    }

    @Test(expected = CommandException.class)
    public void readWithSuperfluousParameter() throws Exception {
        Shell.main("read", "//path/to/file", "//path/to/file");
    }


    @Test
    public void removeFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\removeFileTest.txt";
        createNewTempFile(filePath, "");

        assertTrue(new File(filePath).exists());

        Shell.main("remove", filePath);

        assertFalse(new File(filePath).exists());

    }

    @Test(expected = FileNotFoundException.class)
    public void removeFileWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\blahblahblah.txt";
        Shell.main("remove", filePath);
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

    @Test(expected = CommandException.class)
    public void removeDirectory() throws Exception {
        Shell.main("remove", "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target");
    }

    @Test(expected = CommandException.class)
    public void removeWihoutFileNameParametr() throws Exception {
        Shell.main("remove");
    }

    @Test
    public void appendToFile() throws Exception {
        String filePath = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\appendFileTest.txt";
        createNewTempFile(filePath, "Test text");

        Shell.main("append", filePath, "appended", "text");
        Shell.main("read", filePath);

        assertTrue(systemOutput.toString().contains("Test text appended text"));
    }

    @Test(expected = FileNotFoundException.class)
    public void appendToFileWithWrongPath() throws Exception {
        String filePath = "c:\\Users\\blahblahblah.txt";
        Shell.main("append", filePath, "appended text");
    }

    @Test(expected = CommandException.class)
    public void appendToFileWithoutFilepath() throws Exception {
        Shell.main("append");
    }

    @Test
    public void listDir() throws Exception {
        Shell.main("list", "src\\test\\java");
        assertTrue(systemOutput.toString().contains("study"));
    }

    @Test(expected = FileNotFoundException.class)
    public void listDirWithWrongPath() throws Exception {
        String filePath = "C:\\Users\\blahblahblah.txt";
        Shell.main("list", filePath);
    }

    @Test(expected = CommandException.class)
    public void listDirWithSuperfluousParameter() throws Exception {
        Shell.main("read", "//path/to/file", "//path/to/file");
    }

    @Test(expected = CommandException.class)
    public void listDirFileNameParameter() throws Exception {
        Shell.main("list");
    }

    @Test(expected = CommandException.class)
    public void unknownCommand() throws Exception {
        Shell.main("do something");
    }
}