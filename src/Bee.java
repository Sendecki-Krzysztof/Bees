public abstract class Bee {
    private int multiplier = 1;
    public int timeAdjustment = 30;
    private int value = 0;
    private double variation = .1;
    private double offset;
    private double base = .5;
    private double production;

    int calcValue() {
        return (int)(multiplier * ((production * timeAdjustment)));
    }
    public void printBeeInfo() {
        System.out.println("Production: " + String.format("%,.2f", this.getProduction()) + ".Its value is: " + this.value);
    }
    public void printBeeType() {
        System.out.print("Yellow Bee ");
    }
    abstract public Bee breed(Bee other);

    // ------ Setter and Getter Statements Below ------

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