package barista;

import coffee.*;

import java.util.ArrayList;
import java.util.List;

public class Barista {
    public void makeCoffees(List<String> coffeeOrders) {
        for (String order : coffeeOrders) {

            var listOfOrders = new ArrayList<Coffee>();

            switch (order) {
                case "Americano":
                    listOfOrders.add(new Americano(Intensity.NORMAL, 100));
                    break;
                case "Cappuccino":
                    listOfOrders.add(new Cappuccino(Intensity.NORMAL, 50, 100));
                    break;
                case "PumpkinSpiceLatte":
                    listOfOrders.add(new PumpkinSpiceLatte(Intensity.STRONG, 50, 100, SyrupType.VANILLA, 50));
                    break;
                case "SyrupCappuccino":
                    listOfOrders.add(new SyrupCappuccino(Intensity.LIGHT, 50, 100, SyrupType.CARAMEL));
                    break;
                default:
                    System.out.println("Unknown coffee type: " + order);
            }

            for (Coffee coffee : listOfOrders) {
                if(coffee instanceof Americano) {
                    ((Americano) coffee).makeAmericano();
                } else if (coffee instanceof Cappuccino) {
                    ((Cappuccino) coffee).makeCappuccino();
                }  else if (coffee instanceof SyrupCappuccino) {
                    ((SyrupCappuccino) coffee).makeSyrupCappuccino();
                }  else if (coffee instanceof PumpkinSpiceLatte) {
                    ((PumpkinSpiceLatte) coffee).makePumpkinSpiceLatte();
                } else {
                    System.out.println("something went wrong");
                }
            }
//            switch (order) {
//                case "Americano":
//                    Americano americano = new Americano(Intensity.NORMAL, 100);
////                    americano.printCoffeeDetails();
//                    americano.makeAmericano();
//                    break;
//                case "Cappuccino":
//                    Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50, 100);
////                    cappuccino.printCoffeeDetails();
//                    cappuccino.makeCappuccino();
//                    break;
//                case "PumpkinSpiceLatte":
//                    PumpkinSpiceLatte pumpkinLatte = new PumpkinSpiceLatte(Intensity.STRONG, 50, 100, SyrupType.VANILLA, 50);
////                    pumpkinLatte.printCoffeeDetails();
//                    pumpkinLatte.makePumpkinSpiceLatte();
//                    break;
//                case "SyrupCappuccino":
//                    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 50, 100, SyrupType.CARAMEL);
////                    syrupCappuccino.printCoffeeDetails();
//                    syrupCappuccino.makeSyrupCappuccino();
//                    break;
//                default:
//                    System.out.println("Unknown coffee type: " + order);
//            }
        }
    }
}
