package study.unit2.ex01;

public class Pen {

    enum Color {
        RED,
        GREEN,
        BLACK,
        BLUE,
    }

    private final Color color;
    private final String manufacturer;

    Pen() {
        color = Color.BLUE;
        manufacturer = "NoName";
    }

    Pen(Color color) {
        this.color = color;
        manufacturer = "NoName";
    }

    public Pen(Color color, String manufacturer) {
        this.color = color;
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (color != pen.color) return false;
        return manufacturer.equals(pen.manufacturer);

    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + manufacturer.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" + "color=" + color + ", manufacturer=\"" + manufacturer + "\"} [" + hashCode() + "]";
    }
}
