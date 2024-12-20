public class CarStation {
    private final Queue<Car> queue;
    private final Dineable dinningService;
    private final Refuelable refuelingService;
    public CarStation(Queue<Car> queue, Refuelable refuelingService, Dineable dinningService) {
        this.queue = queue;
        this.dinningService = dinningService;
        this.refuelingService = refuelingService;
    }

    public void serveCars() {
//        System.out.println("Dineable implementation: " + dinningService.getClass().getSimpleName());
//        System.out.println("Refuelable implementation: " + refuelingService.getClass().getSimpleName());
        while (!queue.isEmpty()) {
            Car car = queue.peek();
            if(car.getNeedsDining().equals("yes")){
                dinningService.serveDinner(String.valueOf(car.getId()));
            } else {
                System.out.println("Car " + car.getId() + " Didn't get served");
            }
            refuelingService.refuel(String.valueOf(car.getId()));
            queue.dequeue();
        }
        System.out.println("All cars have been served.");
    }

    public void addCar(Car car) {
        queue.enqueue(car);
//        System.out.println("Car added to queue: " + car);
    }
}
