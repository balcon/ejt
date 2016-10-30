package study.unit2.ex03;

public class Pencil extends Writings {


    public enum Hardness {H, HB, B}

    private final Hardness hardness;

    public Pencil(double price, String manufacturer, Color color, Hardness hardness) {
        super(price, manufacturer, color);
        this.hardness = hardness;
    }

    @Override
    public String getName() {
        return "Pencil";
    }


}
