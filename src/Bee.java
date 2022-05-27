import static java.lang.Double.max;
import static java.lang.Double.min;

public class Bee {
    public String beeType;
    private int sellingValue = 0;
    private int buyingValue = 0;
    private double production = 0;
    private double offset = 0;
    private int valueMultiplier = 1;


    Bee() {
        this.beeType = "Bee";
        this.calcOffset(0, 1);
        double baseProduction = 1;
        this.calcProduction(baseProduction);
        this.calcBuyingValue(valueMultiplier);
        this.calcSellingValue(valueMultiplier);

    }
    private Bee(double minOffset, double maxOffset, double productionFormParents) {
        this.beeType = "Bee";
        this.calcOffset(minOffset, maxOffset);
        double baseProduction = productionFormParents + this.getOffset();
        this.calcProduction(baseProduction);
        this.calcSellingValue(valueMultiplier);
        this.calcBuyingValue(valueMultiplier);
    }

    public void printBeeInfo() {
        System.out.println("Production: " + String.format("%,.2f", this.getProduction()) +
                ". Its Selling value is: " + this.sellingValue + "! Its Buying Price is: " + this.getBuyingValue());
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
        buyingValue = (int) ((production * multiplier) + defaultBuyingPrice);
    }

    public double calcParentProduction(double firstBeeProduction, double secondBeeProduction) {
        double max = max(firstBeeProduction, secondBeeProduction);
        double min = min(firstBeeProduction, secondBeeProduction);

        return ((Math.random() * (max - min)) + min);
    }

    public void calcOffset(double min, double max) {
        offset = ((Math.random() * (max - min)) + min);
    }

    public Bee breed(Bee other){
        double productionFromParents = calcParentProduction(this.getProduction(), other.getProduction());
        double minOffset = min(this.getOffset(), other.getOffset());
        double maxOffset = max(this.getOffset(), other.getOffset());
        return new Bee(minOffset, maxOffset, productionFromParents);
    }

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