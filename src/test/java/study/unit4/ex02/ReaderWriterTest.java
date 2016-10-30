package study.unit4.ex02;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReaderWriterTest {
    @Test
    public void ReadFile() throws Exception {
        String fp=("src\\main\\resources\\study\\unit4\\JavaKeywords.txt");
        Keywords keywords = new Keywords(fp);
        assertTrue(keywords.contains("int"));


    }
}