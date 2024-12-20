public class GasStation implements Refuelable {

    private static int refuelCount = 0;

    @Override
    public void refuel(String carId) {
        refuelCount++;
        System.out.println("Refueling gas car " + carId + ".");
        System.out.println("Total cars refueled: " + refuelCount);
    }

    public static int getCount() {
        return refuelCount;
    }
}
