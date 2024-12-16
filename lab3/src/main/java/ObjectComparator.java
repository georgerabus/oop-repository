import java.util.Comparator;

public class ObjectComparator implements Comparator<testObj> {
    private final String priorityFuel;
    private final String priorityDining;

    // Constructor to accept priority keywords
    public ObjectComparator(String priorityFuel, String priorityDining) {
        this.priorityFuel = priorityFuel;
        this.priorityDining = priorityDining;
    }

    @Override
    public int compare(testObj o1, testObj o2) {
        boolean o1Priority = o1.getFuel().equals(priorityFuel) && o1.getDining().equals(priorityDining);
        boolean o2Priority = o2.getFuel().equals(priorityFuel) && o2.getDining().equals(priorityDining);

        if (o1Priority && !o2Priority) {
            return -1; // o1 has higher priority
        } else if (!o1Priority && o2Priority) {
            return 1; // o2 has higher priority
        }
        return 0; // Both have equal priority
    }
}
