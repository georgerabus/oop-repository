public class CarStation {
    private final Queue<Car> queue;
    private final Dineable peopleDinner;
    private final Dineable robotsDinner;
    private final Refuelable gasStation;
    private final Refuelable electricStation;

    public CarStation(Queue<Car> queue) {
        this.queue = queue;
        this.peopleDinner = new PeopleDinner();
        this.robotsDinner = new RobotsDinner();
        this.gasStation = new GasStation();
        this.electricStation = new ElectricStation();
    }

    public void serveCars() {

        while (!queue.isEmpty()) {
            Car car = queue.peek();
            if(car.getNeedsDining().equals("yes")){
                if (car.getDining().equals("People")){
                    peopleDinner.serveDinner(String.valueOf(car.getId()));
                } else {
                    robotsDinner.serveDinner(String.valueOf(car.getId()));
                }
            } else {
                System.out.println("Car " + car.getId() + " Didn't get served");
            }

            if (car.getFuel().equals("Gas")){
                gasStation.refuel(String.valueOf(car.getId()));
            } else {
                electricStation.refuel(String.valueOf(car.getId()));
            }
            queue.dequeue();
        }
        System.out.println("All cars have been served.");

        // Statistics
        System.out.println("Statistics:");
        System.out.println("Cars that received People Dinner: " + PeopleDinner.getCount());
        System.out.println("Cars that received Robots Dinner: " + RobotsDinner.getCount());
        System.out.println("Cars refueled with Gas: " + GasStation.getCount());
        System.out.println("Cars recharged with Electricity: " + ElectricStation.getCount());
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("Car added to queue: " + car);
    }
}
