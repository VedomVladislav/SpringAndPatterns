package abstractFactory.transport.impl.car;


import abstractFactory.transport.interfaces.Car;

public class Cadillac implements Car {

    public void drive() {
        System.out.println("Drive speed 150 km/h");
    }

    public void stop() {
        System.out.println("Stopped at 1 sec");
    }

}
