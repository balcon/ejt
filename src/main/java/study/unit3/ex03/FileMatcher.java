package study.unit3.ex03;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileMatcher {
    public static void main(String[] args) {
        String inFile = "src\\main\\resources\\study\\unit3\\ex03\\html_text.html";
        String outFile = "src\\main\\resources\\study\\unit3\\ex03\\html_text_highlights.html";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String sourceString = FileRW.readFrom(inFile, "cp1251");
            Pattern pattern = Pattern.compile("[А-ЯA-Z][^.!?]*([Рр]ис[\\.у].{1,9}(\\d+)).*?[^Рис][\\.?!]");
            Matcher matcher = pattern.matcher(sourceString);
            int pictureCounter = 0;
            int pictureCounterMax = 0;
            boolean picturesAscendingOrder = true;
            String matcherGroup;
            while (matcher.find()) {
                if (picturesAscendingOrder) {
                    pictureCounter = Integer.valueOf(matcher.group(2));
                    if (pictureCounter < pictureCounterMax) picturesAscendingOrder = false;
                    pictureCounterMax = pictureCounter;
                }
                pictureCounter = Integer.valueOf(matcher.group(2));
                matcherGroup = matcher.group();
                matcher.appendReplacement(stringBuffer, "<font color=\"red\"><b>" + matcherGroup + "</b></font>");
            }
            matcher.appendTail(stringBuffer);
            FileRW.writeTo(stringBuffer.toString(), outFile, "cp1251");
            System.out.println("Ascending order - " + picturesAscendingOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
