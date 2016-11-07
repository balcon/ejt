package study.unit2.ex02;

import java.util.ArrayList;
import java.util.List;

class WorkSpace {

    private final Employee employee;

    private final List<Stationery> stuff = new ArrayList<>();

    public WorkSpace(Employee employee) {
        this.employee = employee;
    }

    public WorkSpace addStationery(Stationery stationery) {
        stuff.add(stationery);
        return this;
    }

    public void printReport() {
        System.out.println(employee.getFirstName() + " " + employee.getSecondName());
        for (Stationery stationery : stuff) {
            System.out.println("  " + stationery.getType() + ": " + stationery.getPrice());
        }
        System.out.println("TOTAL: $" + totalPrice());
    }

    private int totalPrice() {
        int totalPrice = 0;
        for (Stationery stationery : stuff) {
            totalPrice += stationery.getPrice();
        }
        return totalPrice;
    }

}
