package study.unit2.ex04;

import study.unit2.ex03.Stationery;

import java.util.Comparator;

public class Comparators {

    public static Comparator<Stationery> sortByName() {
        return new Comparator<Stationery>() {

            @Override
            public int compare(Stationery o1, Stationery o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }

    public static Comparator<Stationery> sortByPrice() {
        return new Comparator<Stationery>() {

            @Override
            public int compare(Stationery o1, Stationery o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        };
    }

    public static Comparator<Stationery> sortByPriceAndName() {
        return new Comparator<Stationery>() {

            @Override
            public int compare(Stationery o1, Stationery o2) {
                int compare = Double.compare(o1.getPrice(), o2.getPrice());
                return compare == 0 ? o1.getName().compareTo(o2.getName()) : compare;
            }
        };
    }
}
