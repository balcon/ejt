package study.unit2.ex03;


abstract public class Stationery {
    final double price;
    final String manufacturer;

    public Stationery(double price, String manufacturer) {
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public abstract String getName();

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

}
