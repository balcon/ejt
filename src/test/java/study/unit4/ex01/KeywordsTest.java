package study.unit4.ex01;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class KeywordsTest {

    @Test
    public void readKeywords() throws Exception {
        Keywords keywords = new Keywords("src\\main\\resources\\study\\unit4\\JavaKeywords.txt");
        assertTrue(keywords.contains("class"));
    }
}