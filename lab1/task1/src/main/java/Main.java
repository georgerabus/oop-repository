class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Honda", "Civic", 2023);

        System.out.println(car1.make + " " + car1.model + " " + car1.year);
        System.out.println(car2.make + " " + car2.model + " " + car2.year);
    }
}