import static java.lang.Double.max;
import static java.lang.Double.min;

public class BlueBee extends Bee {
    private final int valueMultiplier = 2;

    BlueBee() {
        this.beeType = "Blue Bee";
        this.calcOffset(0, 1);
        double baseProduction = 1;
        this.calcProduction(baseProduction);
        this.calcBuyingValue(valueMultiplier);
        this.calcSellingValue(valueMultiplier);

    }
    private BlueBee(double minOffset, double maxOffset, double productionFormParents) {

        this.beeType = "Blue Bee";
        this.calcOffset(minOffset, maxOffset);
        double baseProduction = productionFormParents + this.getOffset();
        this.calcProduction(baseProduction);
        this.calcSellingValue(valueMultiplier);
        this.calcBuyingValue(valueMultiplier);
    }
    @Override
    public Bee breed(Bee other) {

        if (!(other instanceof BlueBee)) {
            System.err.println("Invalid Kind of bee!");
        }
        double productionFromParents = calcParentProduction(this.getProduction(), other.getProduction());
        double minOffset = min(this.getOffset(), other.getOffset());
        double maxOffset = max(this.getOffset(), other.getOffset());
        return new BlueBee(minOffset, maxOffset, productionFromParents);
        }
}
