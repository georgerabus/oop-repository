public class PeopleDinner implements Dineable{

    @Override
    public void serveDinner(String carId) {
        System.out.println("Dining people with car " + carId + ".");
    }
}
