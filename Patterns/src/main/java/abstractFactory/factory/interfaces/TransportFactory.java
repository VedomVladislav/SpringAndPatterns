package abstractFactory.factory.interfaces;

import abstractFactory.transport.interfaces.Aircraft;
import abstractFactory.transport.interfaces.Car;

public interface TransportFactory {

    Car createCar();

    Aircraft createAircraft();

}
