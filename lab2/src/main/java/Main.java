enum Intensity {
    LIGHT, NORMAL, STRONG
}

enum SyrupType {
    MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
}

class Coffee {
    protected Intensity coffeeIntensity;
    protected final String coffeeName = "Coffee";

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return coffeeName;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }
}

class Americano extends Coffee {
    private int mlOfWater;
    private final String coffeeName = "Americano";

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println(coffeeName + " water: " + mlOfWater + " ml");
    }

    public final Americano makeAmericano() {
        System.out.println("Making " + coffeeName);
        System.out.println("Intensity set to " + coffeeIntensity);
        System.out.println("Adding " + mlOfWater + " mls of water");
        return this;
    }
}

class Cappuccino extends Americano {
    private int mlOfMilk;
    private final String coffeeName = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfWater, int mlOfMilk) {
        super(intensity, mlOfWater);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public String getCoffee() {
        return coffeeName;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println(coffeeName + " water: " + getMlOfWater() + " ml, milk: " + mlOfMilk + " mg");
    }

    public final Cappuccino makeCappuccino() {
        System.out.println("Making " + coffeeName);
        System.out.println("Intensity set to " + coffeeIntensity);
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        return this;
    }
}

class SyrupCappuccino extends Cappuccino {
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

class PumpkinSpiceLatte extends SyrupCappuccino {
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

public class Main {
    public static void main(String[] args) {
        PumpkinSpiceLatte coffee = new PumpkinSpiceLatte(Intensity.NORMAL, 50, 100, SyrupType.CHOCOLATE, 50);
        coffee.makePumpkinSpiceLatte();
    }
}
