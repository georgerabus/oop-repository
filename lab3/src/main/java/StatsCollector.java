import java.util.HashMap;
import java.util.Map;

public class StatsCollector {
    // Following the structure from the Python script:
    // {
    //   "ELECTRIC": 0, "GAS": 0,
    //   "PEOPLE": 0, "ROBOTS": 0,
    //   "DINING": 0, "NOT_DINING": 0,
    //   "CONSUMPTION": {"ELECTRIC": 0, "GAS": 0}
    // }

    private int electricCount = 0;
    private int gasCount = 0;
    private int peopleCount = 0;
    private int robotsCount = 0;
    private int diningCount = 0;
    private int notDiningCount = 0;
    private int electricConsumption = 0;
    private int gasConsumption = 0;

    public synchronized void updateStats(Car car) {
        String carType = car.getType();
        String passengerType = car.getPassengers();
        boolean isDining = car.isDining();
        int consumption = car.getConsumption();

        if ("ELECTRIC".equalsIgnoreCase(carType)) {
            electricCount++;
            electricConsumption += consumption;
        } else {
            gasCount++;
            gasConsumption += consumption;
        }

        if ("PEOPLE".equalsIgnoreCase(passengerType)) {
            peopleCount++;
        } else {
            robotsCount++;
        }

        if (isDining) {
            diningCount++;
        } else {
            notDiningCount++;
        }
    }

    public void printStats() {
        // Print in the same JSON-like structure as the Python script:
        // {"ELECTRIC": X, "GAS": Y, "PEOPLE": Z, "ROBOTS": A, "DINING": B, "NOT_DINING": C,
        //  "CONSUMPTION": {"ELECTRIC": E, "GAS": G}}

        System.out.println("{\"ELECTRIC\": " + electricCount + ", " +
                "\"GAS\": " + gasCount + ", " +
                "\"PEOPLE\": " + peopleCount + ", " +
                "\"ROBOTS\": " + robotsCount + ", " +
                "\"DINING\": " + diningCount + ", " +
                "\"NOT_DINING\": " + notDiningCount + ", " +
                "\"CONSUMPTION\": {\"ELECTRIC\": " + electricConsumption + ", \"GAS\": " + gasConsumption + "}}");
    }
}
