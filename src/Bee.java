import static java.lang.Double.max;
import static java.lang.Double.min;

public abstract class Bee {
    private int multiplier = 1;
    private int value = 0;
    private double variation = .1;
    private double offset;
    private double base = 1;
    private double production;

    int calcValue() {
        return (int)(multiplier * ((production * 60) + 100));
    }
    public void printInfo() {
        System.out.println("Production: " + String.format("%,.2f", this.getProduction()) + ".Its value is: " + this.value);
    }
    public void printType() {
        System.out.print("Yellow Bee ");
    }
    abstract public Bee breed(Bee other);


    public double getVariation() {
        return variation;
    }

    public void setVariation(double variation) {
        this.variation = variation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getProduction() {
        return production;
    }

    public void setProduction(double production) {
        this.production = production;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}