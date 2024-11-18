package coffee;

public class Cappuccino extends Americano {
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

    // base method
    public void makeRecipe() {
        System.out.println("Intensity set to " + coffeeIntensity);
        System.out.println("Adding " + mlOfMilk + " mls of milk");
    }


    // specialized method
    public final Cappuccino makeCappuccino() {
        System.out.println("Making " + coffeeName);
        this.makeRecipe();
        return this;
    }
}