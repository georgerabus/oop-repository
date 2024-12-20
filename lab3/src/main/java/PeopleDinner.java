public class PeopleDinner implements Dineable{
    private static int peopleServed = 0;
    @Override
    public void serveDinner(String carId) {
        peopleServed++;
        System.out.println("Serving dinner to people in car " + carId + ".");
//        System.out.println("Total people served: " + peopleServed);
    }
    public static int getCount() {
        return peopleServed;
    }
}
