package study.unit2.ex03;

abstract public class Writings extends Stationery {

    public enum Color {RED, GREEN, BLACK, BLUE, YELLOW}

    private final Color color;

    public Writings(double price, String manufacturer, Color color) {
        super(price, manufacturer);
        this.color = color;
    }

}
