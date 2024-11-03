class Display {
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

    public void compareSize(Display m) {
        int thisSize = this.width * this.height;
        int otherSize = m.width * m.height;

        if (thisSize > otherSize) {
            System.out.println(this.model + " is larger in size than " + m.model);
        } else if (thisSize < otherSize) {
            System.out.println(m.model + " is larger in size than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same size.");
        }
    }

    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is sharper than " + m.model);
        } else if (this.ppi < m.ppi) {
            System.out.println(m.model + " is sharper than " + this.model);
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness.");
        }
    }

    public void compareWithMonitor(Display m) {
        int thisSize = this.width * this.height;
        int otherSize = m.width * m.height;
        boolean sizeComparison = thisSize > otherSize;
        boolean sharpnessComparison = this.ppi > m.ppi;

        if (sizeComparison && sharpnessComparison) {
            System.out.println(this.model + " is larger and sharper than " + m.model);
        } else if (sizeComparison) {
            System.out.println(this.model + " is larger than " + m.model + " but not sharper.");
        } else if (sharpnessComparison) {
            System.out.println(this.model + " is sharper than " + m.model + " but not larger.");
        } else {
            System.out.println(m.model + " is larger and sharper than " + this.model);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 401, "Display A");
        Display display2 = new Display(2560, 1440, 326, "Display B");
        Display display3 = new Display(3840, 2160, 458, "Display C");

        display1.compareSize(display2);
        display2.compareSharpness(display3);
        display1.compareWithMonitor(display3);
    }
}
