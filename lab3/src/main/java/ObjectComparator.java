import java.util.Comparator;

public class ObjectComparator implements Comparator<testObj> {
    @Override
    public int compare(testObj o1, testObj o2) {
        boolean o1Priority = o1.getDining().equals("Gas") && o1.getFuel().equals("People");
        boolean o2Priority = o2.getDining().equals("Gas") && o2.getFuel().equals("People");

        if (o1Priority && !o2Priority) {
            return -1; // o1 has higher priority
        } else if (!o1Priority && o2Priority) {
            return 1; // o2 has higher priority
        }
        return 0;
    }
}
