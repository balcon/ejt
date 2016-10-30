package study.unit3.ex03;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex03Test {

    @Test
    public void test(){
        String fileName="C:\\Users\\Balcon\\Documents\\JavaProjects\\epamJavaTraining\\src\\main\\resources\\study\\unit3\\ex03\\html_text.html";
        try (Scanner scanner=new Scanner(new File(fileName))){
            while(scanner.hasNext()) {
                System.out.println(scanner.next());
            }
            System.out.println("wtf");
        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
            System.out.println("nop");
        }

    }
    @Test
    public void test2(){
        String list[] = new File(".").list();
        for(int i = 0; i < list.length; i++)
            System.out.println(list[i]);
    }
}
