package coffee;

public class PumpkinSpiceLatte extends SyrupCappuccino {
    private int mgOfPumpkinSpice;
    private final String coffeeName = "Pumpkin Spice Latte";

    public PumpkinSpiceLatte(Intensity intensity, int mlOfWater, int mlOfMilk, SyrupType syrup, int mgOfPumpkinSpice) {
        super(intensity, mlOfWater, mlOfMilk, syrup);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    public String getName() {
        return coffeeName;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println(coffeeName + " water: " + getMlOfWater() + " ml, milk: " + getMlOfMilk() + " mg, syrup: " + getSyrup() + ", pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }

    public final PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("Making " + coffeeName);
        System.out.println("Intensity set to " + coffeeIntensity);
        System.out.println("Adding " + getMlOfMilk() + " mls of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mls of pumpkin spice");
        return this;
    }
}