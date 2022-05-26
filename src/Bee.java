import static java.lang.Double.max;
import static java.lang.Double.min;

public abstract class Bee {
    public String beeType = "Bee";
    private int sellingValue = 0;
    private int buyingValue = 0;
    private double production = 0;
    private double offset = 0;


    public void printBeeInfo() {
        System.out.println("Production: " + String.format("%,.2f", this.getProduction()) + ".Its Selling value is: " + this.sellingValue);
    }
    public void printBeeType() {
        System.out.print(beeType + " ");
    }

    public void calcProduction(double base) {
        production = Math.random() + base;
    }
    public void calcSellingValue(int multiplier) {
        double defaultSellingPrice = 50;
        sellingValue = (int) ((production * multiplier) + defaultSellingPrice);
    }
    public void calcBuyingValue(int multiplier) {
        double defaultBuyingPrice = 200;
        sellingValue = (int) ((production * multiplier) + defaultBuyingPrice);
    }

    public double calcParentProduction(double firstBeeProduction, double secondBeeProduction) {
        double max = max(firstBeeProduction, secondBeeProduction);
        double min = min(firstBeeProduction, secondBeeProduction);

        return ((Math.random() * (max - min)) + min);
    }

    public void calcOffset(double min, double max) {
        offset = ((Math.random() * (max - min)) + min);
    }

    abstract public Bee breed(Bee other);

    /* ---------- Getters ---------- */
    public double getProduction() {
        return production;
    }
    public int getSellingValue() {
        return sellingValue;
    }
    public int getBuyingValue() {
        return buyingValue;
    }
    public double getOffset() { return offset; }
}