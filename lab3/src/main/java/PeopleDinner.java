public class PeopleDinner implements Dineable{
    private static int peopleServed = 0;
    @Override
    public void serveDinner(String carId, String isDining) {
        if (isDining.equals("yes")) {
            peopleServed++;
            System.out.println("Serving dinner to people in car " + carId + ".");
            System.out.println("Total people served: " + peopleServed);
        } else {
            System.out.println("Car " +carId + " Didn't get served");
        }
    }
}
