import static java.lang.Double.max;
import static java.lang.Double.min;

public class YellowBee extends  Bee{
    private final int valueMultiplier = 1;
    private final int productionMultiplier = 1;


    YellowBee() {
        this.setMultiplier(valueMultiplier);
        this.setBase(1);
        this.setOffset(Math.random());
        this.setProduction((productionMultiplier * (getBase() + getOffset()) / timeAdjustment));
        this.setValue(this.calcValue());
    }
    private YellowBee(double min, double max) {
        this.setMultiplier(valueMultiplier);
        this.setOffset((Math.random() * (max - min)) + min);
        this.setProduction((productionMultiplier * (getBase() + getOffset()) / timeAdjustment));
        this.setValue(calcValue());
    }

    @Override
    public void printBeeType() {
        System.out.print("Yellow Bee ");
    }

    @Override
    public Bee breed(Bee other) {

        if (!(other instanceof YellowBee)) {
            System.err.println("Invalid Kind of bee!");
        }
        return new YellowBee(min(this.getOffset(), other.getOffset()),
                (max(this.getOffset(), other.getOffset()) + Math.random() + this.getVariation()));
    }
}
