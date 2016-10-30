package study.unit2.ex02;

import java.util.ArrayList;

class Stationery {

    private final String type;
    private final int price;


    public Stationery(String type, int price) {

        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
