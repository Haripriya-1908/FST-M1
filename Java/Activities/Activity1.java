package Activity;

public class Activity1 {

    public static void main(String[] args) {

        Car Honda = new Car();

        Honda.make = 2023;
        Honda.color = "Blue";
        Honda.transmission = "Automatic";

        Honda.displayCharacteristics();
        Honda.accelarate();
        Honda.brake();
       
    }
}
