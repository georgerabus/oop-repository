import barista.Barista;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        barista.makeCoffees(Arrays.asList("Americano", "Cappuccino", "PumpkinSpiceLatte"));
    }
}
