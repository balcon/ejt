package study.unit4.ex03;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class CyrillicUTFConverterTest {
    @Test
    public void testRead() throws IOException {
        String fi = "src\\main\\resources\\study\\unit4\\ex03\\source_utf-8.txt";
        String fo = "src\\main\\resources\\study\\unit4\\ex03\\result_utf-16.txt";
        File ifile = new File(fi);
        File ofile=new File(fo);
        Scanner scanner=new Scanner(ifile,"utf8");
        try(PrintWriter printWriter=new PrintWriter(fo,"utf-16")){

       while(scanner.hasNextLine()){
            printWriter.println(scanner.nextLine());}
        }
scanner.close();

    }
}