package study.unit4.ex02;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Keywords {
    private Set<String> keywords;

    public Keywords(String filePath) throws IOException {
        this.keywords = readKeywords(filePath);
    }

    private Set<String> readKeywords(String filePath) throws IOException {
        Set<String> keywords = new HashSet<>();

        for (String keyword : ReaderWriter.readFrom(filePath)) {
            keywords.add(keyword);
        }
        return keywords;
    }

    public boolean contains(String keyword) {
        return keywords.contains(keyword);
    }
}
