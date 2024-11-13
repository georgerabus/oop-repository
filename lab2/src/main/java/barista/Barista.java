package barista;

import coffee.Americano;
import coffee.Cappuccino;
import coffee.Intensity;
import coffee.PumpkinSpiceLatte;
import coffee.SyrupCappuccino;
import coffee.SyrupType;
import java.util.List;

public class Barista {
    public void makeCoffees(List<String> coffeeOrders) {
        for (String order : coffeeOrders) {
            switch (order) {
                case "Americano":
                    Americano americano = new Americano(Intensity.NORMAL, 100);
                    americano.printCoffeeDetails();
                    americano.makeAmericano();
                    break;
                case "Cappuccino":
                    Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50, 100);
                    cappuccino.printCoffeeDetails();
                    cappuccino.makeCappuccino();
                    break;
                case "PumpkinSpiceLatte":
                    PumpkinSpiceLatte pumpkinLatte = new PumpkinSpiceLatte(Intensity.STRONG, 50, 100, SyrupType.VANILLA, 50);
                    pumpkinLatte.printCoffeeDetails();
                    pumpkinLatte.makePumpkinSpiceLatte();
                    break;
                case "SyrupCappuccino":
                    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 50, 100, SyrupType.CARAMEL);
                    syrupCappuccino.printCoffeeDetails();
                    syrupCappuccino.makeSyrupCappuccino();
                    break;
                default:
                    System.out.println("Unknown coffee type: " + order);
            }
        }
    }
}
