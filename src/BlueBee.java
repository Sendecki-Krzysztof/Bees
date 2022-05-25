import static java.lang.Double.max;
import static java.lang.Double.min;

public class BlueBee extends Bee {
    private final int valueMultiplier = 2;

    BlueBee() {
        this.setMultiplier(valueMultiplier);
        this.setBase(1);
        this.setOffset(Math.random());
        this.setVariation((getBase() + getOffset()) / 60);
        this.setValue(this.calcValue());
    }
    private BlueBee(double min, double max) {
        this.setMultiplier(valueMultiplier);
        this.setOffset((Math.random() * (max - min)) + min);
        this.setProduction((getBase() + getOffset()) / 60);
        this.setValue(calcValue());
    }
    @Override
    public void printBeeType() {
        System.out.print("Blue Bee ");
    }

    @Override
    public Bee breed(Bee other) {
        if (other instanceof BlueBee) {
            return new BlueBee(min(this.getOffset(), other.getOffset()), (max(this.getOffset(), other.getOffset()) + Math.random() * this.getVariation()));
        } else {
            System.out.println("Invalid Kind of bee!");
            return null;
        }
    }
}
