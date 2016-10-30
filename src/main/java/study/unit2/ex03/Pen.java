package study.unit2.ex03;



public class Pen extends Writings {
    public enum InkType{INK, OIL, GEL}

    private final InkType inkType;

   public Pen(double price, String manufacturer, Color color, InkType inkType) {
       super(price, manufacturer, color);
       this.inkType = inkType;
   }

    @Override
    public String getName() {
        return "Pen";
    }
}
