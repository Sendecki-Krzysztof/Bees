import static java.lang.Double.max;
import static java.lang.Double.min;

public class BlueBee extends Bee {
    private int valueMultiplier = 1;

    BlueBee() {
        this.setMultiplier(valueMultiplier);
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
    public void printType() {
        System.out.print("Blue Bee ");
    }

    @Override
    public Bee breed(Bee other) {
        return new BlueBee(min(this.getOffset(), other.getOffset()), (max(this.getOffset(), other.getOffset()) + Math.random() * this.getVariation()));
    }
}
