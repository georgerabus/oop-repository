import java.util.Comparator;

public class ObjectComparator implements Comparator<Car> {
    private final String priorityFuel;
    private final String priorityDining;

    public ObjectComparator(String priorityFuel, String priorityDining) {
        this.priorityFuel = priorityFuel;
        this.priorityDining = priorityDining;
    }

    @Override
    public int compare(Car o1, Car o2) {
        boolean o1Priority = o1.getType().equals(priorityFuel) && o1.getPassengers().equals(priorityDining);
        boolean o2Priority = o2.getType().equals(priorityFuel) && o2.getPassengers().equals(priorityDining);

        if (o1Priority && !o2Priority) {
            return -1;
        } else if (!o1Priority && o2Priority) {
            return 1;
        }
        return 0;
    }
}
