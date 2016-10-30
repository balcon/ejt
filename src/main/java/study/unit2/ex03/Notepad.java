package study.unit2.ex03;


public class Notepad extends Stationery {

    public enum SheetSize{A4,A5,A6}
    private final SheetSize sheetSize;
    private final int sheetsNumber;

    public Notepad(double price, String manufacturer, SheetSize sheetSize, int sheetsNumber) {
        super(price, manufacturer);
        this.sheetSize = sheetSize;
        this.sheetsNumber = sheetsNumber;
    }

    @Override
    public String getName() {
        return "Notepad";
    }




}
