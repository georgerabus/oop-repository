public class testObj {

    private String fuel;
    private String dining;

    public testObj(String dining, String fuel) {
        this.dining = dining;
        this.fuel = fuel;
    }

    public String getDining() {
        return dining;
    }

    public String getFuel() {
        return fuel;
    }


    public String toString() {
        return "testObj {dining = '" + dining + "', fuel ='" + fuel + "'}";
    }
}
