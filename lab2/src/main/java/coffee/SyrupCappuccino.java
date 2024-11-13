package coffee;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private final String coffeeName = "Syrup Cappuccino";

    public SyrupCappuccino(Intensity intensity, int mlOfWater, int mlOfMilk, SyrupType syrup) {
        super(intensity, mlOfWater, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    public String getCoffee() {
        return coffeeName;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println(coffeeName + " water: " + getMlOfWater() + " ml, milk: " + getMlOfMilk() + " mg, syrup: " + syrup);
    }

    public final SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making " + coffeeName);
        System.out.println("Intensity set to " + coffeeIntensity);
        System.out.println("Adding " + getMlOfMilk() + " mls of milk");
        System.out.println("Adding syrup: " + syrup);
        return this;
    }
}
