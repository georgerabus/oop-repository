public class ElectricStation implements Refuelable{
    private static int rechargeCount = 0;

    @Override
    public void refuel(String carId) {
        rechargeCount++;
        System.out.println("Recharging electric car " + carId + ".");
        System.out.println("Total cars recharged: " + rechargeCount);
    }
    public static int getCount() {
        return rechargeCount;
    }
}
