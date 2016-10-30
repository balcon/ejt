package study.unit2.ex03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Ex03Test {


    @Test
    public void initCollection() {
        showAll(compileToolkit());
    }

    public static List<Stationery> compileToolkit() {
        List<Stationery> noviceToolkit = new ArrayList<>();
        noviceToolkit.add(new Pen(5.5, "Edding", Writings.Color.BLUE, Pen.InkType.INK));
        noviceToolkit.add(new Pencil(2.6, "Koh-I-Noor", Writings.Color.BLACK, Pencil.Hardness.HB));
        noviceToolkit.add(new Notepad(10.50, "NoName", Notepad.SheetSize.A6, 50));
        noviceToolkit.add(new Stapler(9.75, "Xerox", Stapler.BracketSize.MEDIUM));
        noviceToolkit.add(new Pencil(9.75, "Koh-I-Noor", Writings.Color.RED, Pencil.Hardness.B));
        return noviceToolkit;
    }

    public static void showAll(List<Stationery> toolKit) {
        for (Stationery stationery : toolKit) {
            System.out.printf("name [%s], manufacturer [%s], price [%.2f]\n", stationery.getName(), stationery.getManufacturer(), stationery.getPrice());
        }
        System.out.println();
    }
}