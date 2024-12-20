public class CarStation {
    private final Queue<Car> queue;
    private final Dineable dinningService;
    private final Refuelable refuelingService;
    private static int Dining;
    private static int Not_dining;

    public CarStation(Queue<Car> queue, Refuelable refuelingService, Dineable dinningService) {
        this.queue = queue;
        this.dinningService = dinningService;
        this.refuelingService = refuelingService;
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.peek();
            if(car.isDining()){
                dinningService.serveDinner(String.valueOf(car.getId()));
                Dining++;
            } else {
                System.out.println("Car " + car.getId() + " Didn't get served");
                Not_dining++;
            }
            refuelingService.refuel(String.valueOf(car.getId()));
            queue.dequeue();
        }
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public static int getDining(){
        return Dining;
    }

    public static int getNot_dining(){
        return Not_dining;
    }
}
