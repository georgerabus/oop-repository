public class Car {

    private String fuel;
    private String dining;
    private int id;
    private String needsDining;

    public Car(int id, String fuel, String dining, String needsDining) {
        this.dining = dining;
        this.fuel = fuel;
        this.id = id;
        this.needsDining = needsDining;
    }

    public String getDining() {
        return dining;
    }

    public String getFuel() {
        return fuel;
    }

    public int getId() {return id;}

    public String getNeedsDining() {return needsDining;}

    @Override
    public String toString() {
        return "Car {id = " + id + ", fuel = '" + fuel + "', dining = '" + dining + "', wish to dine = '" + needsDining + "'}";
    }
}
