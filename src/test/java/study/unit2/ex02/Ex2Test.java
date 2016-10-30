package study.unit2.ex02;

import org.junit.Test;

public class Ex2Test {

    @Test
    public void test() {

        Stationery pen2 = new Stationery("pen", 100);
        Stationery notepad = new Stationery("notepad", 45);
        Stationery highlighter = new Stationery("highlighter", 35);

        WorkSpace workSpace = new WorkSpace(new Employee("John", "Smith"));

        workSpace.addStationery(pen2)
                .addStationery(notepad)
                .addStationery(highlighter)
                .addStationery(new Stationery("calc", 135));

        workSpace.printReport();

    }


}