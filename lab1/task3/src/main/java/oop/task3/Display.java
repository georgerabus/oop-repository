package oop.task3;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void compareSize(Display other) {
        if (this.width * this.height > other.width * other.height) {
            System.out.println(this.model + " is larger than " + other.model);
        } else if (this.width * this.height < other.width * other.height) {
            System.out.println(this.model + " is smaller than " + other.model);
        } else {
            System.out.println(this.model + " is the same size as " + other.model);
        }
    }

    public void compareSharpness(Display other) {
        if (this.ppi > other.ppi) {
            System.out.println(this.model + " is sharper than " + other.model);
        } else if (this.ppi < other.ppi) {
            System.out.println(this.model + " is less sharp than " + other.model);
        } else {
            System.out.println(this.model + " has the same sharpness as " + other.model);
        }
    }
}
