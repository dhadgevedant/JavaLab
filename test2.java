// Java program to demonstrate constructors
class Car {
    String brand;
    int year;

    // Default Constructor
    Car() {
        this.brand = "Unknown";
        this.year = 0;
        System.out.println("Default Constructor Called");
    }

    // Parameterized Constructor
    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("Parameterized Constructor Called");
    }

    // Constructor Overloading
    Car(String brand) {
        this.brand = brand;
        this.year = 2024; // Default year if not provided
        System.out.println("Overloaded Constructor Called");
    }

    void display() {
        System.out.println("Car Brand: " + brand + ", Year: " + year);
    }
}

class test2{

    public static void main(String[] args) {
        // Creating objects with different constructors
        Car car1 = new Car(); // Calls default constructor
        car1.display();
        
        Car car2 = new Car("Toyota", 2022); // Calls parameterized constructor
        car2.display();
        
        Car car3 = new Car("Honda"); // Calls overloaded constructor
        car3.display();
    }
}
