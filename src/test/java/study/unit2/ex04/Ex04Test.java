package study.unit2.ex04;

import org.junit.Test;
import study.unit2.ex03.Ex03Test;
import study.unit2.ex03.Stationery;

import java.util.Collections;
import java.util.List;

public class Ex04Test {

    private final List<Stationery> stationeries = Ex03Test.compileToolkit();

    @Test
    public void testByPrice() throws Exception {
        Collections.sort(stationeries,Comparators.sortByPrice());

        System.out.println("Sort by price");
        Ex03Test.showAll(stationeries);
     }

    @Test
    public void testByName() throws Exception {
        Collections.sort(stationeries,Comparators.sortByName());

        System.out.println("Sort by name");
        Ex03Test.showAll(stationeries);
    }

    @Test
    public void testByPriceAndName() throws Exception {
        Collections.sort(stationeries,Comparators.sortByPriceAndName());

        System.out.println("Sort by price and name");
        Ex03Test.showAll(stationeries);
    }
}