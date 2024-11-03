class Car {
    String make;
    String model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    boolean isSameMake(Car otherCar) {
        return this.make.equals(otherCar.make);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2022);
        Car car2 = new Car("Toyota", "Corolla", 2023);
        Car car3 = new Car("Honda", "Civic", 2023);

        System.out.println(car1.isSameMake(car2)); // true
        System.out.println(car1.isSameMake(car3)); // false
    }
}
