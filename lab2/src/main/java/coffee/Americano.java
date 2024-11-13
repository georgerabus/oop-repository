package coffee;

public class Americano extends Coffee {
    protected int mlOfWater;
    private final String coffeeName = "Americano";

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public void printCoffeeDetails() {
        System.out.println(coffeeName + " water: " + mlOfWater + " ml");
    }

    public void makeAmericano() {
        System.out.println("Making Americano");
        System.out.println("Intensity set to " + coffeeIntensity);
        System.out.println("Adding " + mlOfWater + " mls of water");
    }
}
