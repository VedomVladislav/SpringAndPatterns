package abstractFactory.transport.impl.car;

import abstractFactory.transport.interfaces.Car;

public class Niva implements Car {

    public void drive() {
        System.out.println("Niva drive");
    }

    public void stop() {
        System.out.println("Niva stopped");
    }

}
