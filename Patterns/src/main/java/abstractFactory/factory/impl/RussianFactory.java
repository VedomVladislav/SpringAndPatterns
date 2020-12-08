package abstractFactory.factory.impl;

import abstractFactory.factory.interfaces.TransportFactory;
import abstractFactory.transport.impl.aircraft.TU134;
import abstractFactory.transport.impl.car.Niva;
import abstractFactory.transport.interfaces.Aircraft;
import abstractFactory.transport.interfaces.Car;

public class RussianFactory implements TransportFactory {

    public Car createCar() {
        return new Niva();
    }

    public Aircraft createAircraft() {
        return new TU134();
    }
}
