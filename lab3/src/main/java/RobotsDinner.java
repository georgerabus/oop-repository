public class RobotsDinner implements Dineable{
    private static int robotsServed = 0;

    @Override
    public void serveDinner(String carId, String isDining) {
        if (isDining.equals("yes")) {
            robotsServed++;
            System.out.println("Serving dinner to robots in car " + carId + ".");
            System.out.println("Total robots served: " + robotsServed);
        } else {
            System.out.println("Car " + carId + " Didn't get served");
        }
    }
}
