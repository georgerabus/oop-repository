public class RobotsDinner implements Dineable{
    private static int robotsServed = 0;

    @Override
    public void serveDinner(String carId) {
        robotsServed++;
        System.out.println("Serving dinner to robots in car " + carId + ".");
        System.out.println("Total robots served: " + robotsServed);
    }

    public static int getCount() {
        return robotsServed;
    }
}
