package coffee;

public class Coffee {
    protected Intensity coffeeIntensity;
    protected final String coffeeName = "Coffee";

    protected Coffee(Intensity coffeeIntensity) {
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
