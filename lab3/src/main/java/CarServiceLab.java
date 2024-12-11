import java.util.ArrayList;
import java.util.List;

public class CarServiceLab {
    private final List<CarServiceStation> stations = new ArrayList<>();
    private final StatsCollector statsCollector;

    public CarServiceLab(StatsCollector statsCollector) {
        this.statsCollector = statsCollector;
        initStations();
    }

    private void initStations() {
        // For all combinations:
        for (CarType c : CarType.values()) {
            for (PassengerType p : PassengerType.values()) {
                for (boolean d : new boolean[]{true, false}) {
                    stations.add(new CarServiceStation(c, p, d, new ArrayQueue<>(), statsCollector));
                }
            }
        }
    }

    public void enqueueCar(Car car) {
        for (CarServiceStation station : stations) {
            if (station.canHandle(car)) {
                station.enqueueCar(car);
                return;
            }
        }
        // If we got here, we found no suitable station (should never happen)
        System.err.println("No suitable station found for car: " + car);
    }

    public void processAll() {
        for (CarServiceStation station : stations) {
            station.processAllCars();
        }
    }

    public void printStats() {
        statsCollector.printStats();
    }
}
