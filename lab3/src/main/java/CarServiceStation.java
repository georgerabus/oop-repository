public class CarServiceStation {
    private final CarType carType;
    private final PassengerType passengerType;
    private final boolean isDiningAllowed;

    private final Queue<Car> carQueue;
    private final StatsCollector statsCollector;

    public CarServiceStation(CarType carType, PassengerType passengerType, boolean isDiningAllowed, Queue<Car> queue, StatsCollector statsCollector) {
        this.carType = carType;
        this.passengerType = passengerType;
        this.isDiningAllowed = isDiningAllowed;
        this.carQueue = queue;
        this.statsCollector = statsCollector;
    }

    public boolean canHandle(Car car) {
        return CarType.valueOf(car.getType()).equals(carType)
                && PassengerType.valueOf(car.getPassengers()).equals(passengerType)
                && car.isDining() == isDiningAllowed;
    }

    public void enqueueCar(Car car) {
        carQueue.enqueue(car);
    }

    // Process all cars in this station
    public void processAllCars() {
        while (!carQueue.isEmpty()) {
            Car car = carQueue.dequeue();
            processCar(car);
        }
    }

    private void processCar(Car car) {
        // Simulate charging/refueling
        // Simulate dining if applicable
        // Update stats
        statsCollector.updateStats(car);
    }
}
