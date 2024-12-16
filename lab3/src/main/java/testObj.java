public class testObj {

    private String fuel;
    private String dining;
    private int id;
    private String does_dine;

    public testObj(int id, String dining, String fuel, String does_dine) {
        this.dining = dining;
        this.fuel = fuel;
        this.id = id;
        this.does_dine = does_dine;
    }

    public String getDining() {
        return dining;
    }

    public String getFuel() {
        return fuel;
    }

    public int getId() {return id;}

    public String getDoes_dine() {return does_dine;}

    @Override
    public String toString() {
        return "testObj {id = " + id + ", dining = '" + dining + "', fuel = '" + fuel + "', wants to dine = '" + does_dine + "'}";
    }
}
