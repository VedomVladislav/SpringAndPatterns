package abstractFactory.factory.impl;

import abstractFactory.factory.interfaces.TransportFactory;
import abstractFactory.transport.impl.aircraft.Boeng747;
import abstractFactory.transport.impl.car.Cadillac;
import abstractFactory.transport.interfaces.Aircraft;
import abstractFactory.transport.interfaces.Car;

public class USAFactory implements TransportFactory {

    public Car createCar() {
        return new Cadillac();
    }

    public Aircraft createAircraft() {
        return new Boeng747();
    }
}
