package study.unit5.ex01;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileSystemTest {

    private final String directory = "C:\\Users\\Balcon\\Documents\\JavaProjects\\ejt\\target\\";
    private final FileSystem fileSystem = new FileSystem();

    @Test
    public void testCreateFile() throws Exception {
        String fileName = "createFileTest.txt";
        fileSystem.createFile(getFilePath(fileName));

        assertTrue(new File(getFilePath(fileName)).exists());
    }

    @Test
    public void testReadFile() throws Exception {
        String fileName = "readFileTest.txt";
        writeToNewFile(getFilePath(fileName), "test string");

        String fileContent = fileSystem.readFile(getFilePath(fileName));

        assertEquals("test string", fileContent);
    }

    private String getFilePath(String fileName) {
        return directory + fileName;
    }

    private void writeToNewFile(String filePath, String content) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(filePath)) {
            printWriter.write(content);
        }

    }

}
