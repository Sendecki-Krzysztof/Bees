import static java.lang.Double.max;
import static java.lang.Double.min;

public class YellowBee extends Bee{
    private final int valueMultiplier = 1;

    YellowBee() {
        this.beeType = "Yellow Bee";
        this.calcOffset(0, 1);
        double baseProduction = 1;
        this.calcProduction(baseProduction);
        this.calcBuyingValue(valueMultiplier);
        this.calcSellingValue(valueMultiplier);

    }
    private YellowBee(double minOffset, double maxOffset, double productionFormParents) {
        this.beeType = "Yellow Bee";
        this.calcOffset(minOffset, maxOffset);
        double baseProduction = productionFormParents + this.getOffset();
        this.calcProduction(baseProduction);
        this.calcSellingValue(valueMultiplier);
        this.calcBuyingValue(valueMultiplier);
    }

    @Override
    public Bee breed(Bee other) {

        if (!(other instanceof YellowBee)) {
            System.err.println("Invalid Kind of bee!");
        }
        double productionFromParents = calcParentProduction(this.getProduction(), other.getProduction());
        double minOffset = min(this.getOffset(), other.getOffset());
        double maxOffset = max(this.getOffset(), other.getOffset());
        return new YellowBee(minOffset, maxOffset, productionFromParents);
    }
}
