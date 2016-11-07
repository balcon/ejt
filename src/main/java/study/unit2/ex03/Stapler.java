package study.unit2.ex03;


public class Stapler extends Stationery {
    public enum BracketSize {SMALL, MEDIUM}

    private final BracketSize bracketSize;

    public Stapler(double price, String manufacturer, BracketSize bracketSize) {
        super(price, manufacturer);
        this.bracketSize = bracketSize;
    }

    @Override
    public String getName() {
        return "Stapler";
    }


}
