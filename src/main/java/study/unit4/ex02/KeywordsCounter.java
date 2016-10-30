package study.unit4.ex02;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class KeywordsCounter {

    public static void main(String[] args) {
        String inputPath = "src\\main\\java\\study\\unit4\\ex02\\KeywordsCounter.java";
        String outputPath = "src\\main\\resources\\study\\unit4\\ex02\\resultKeywords.txt";

        try {
            Keywords keywords = new Keywords("src\\main\\resources\\study\\unit4\\JavaKeywords.txt");
            String[] contentArray = ReaderWriter.readFrom(inputPath);
            Map<String, Integer> counters = countKeywordsInContent(keywords, contentArray);
            writeCountersToFile(outputPath, counters);
        } catch (IOException e) {
            System.out.println("File can not be R/W");
        }
    }

    private static void writeCountersToFile(String outputPath, Map<String, Integer> counters) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> keyword : counters.entrySet()) {
            stringBuilder.append(keyword.getValue()).append("\t").append(keyword.getKey()).append(System.lineSeparator());
        }
        ReaderWriter.writeTo(stringBuilder.toString(), outputPath);
    }

    private static Map<String, Integer> countKeywordsInContent(Keywords keywords, String[] contentArray) {
        Map<String, Integer> counters = new HashMap<>();
        for (String res : contentArray) {
            if (keywords.contains(res)) {
                counters.put(res, counters.getOrDefault(res, 0) + 1);
            }
        }
        return counters;
    }
}
