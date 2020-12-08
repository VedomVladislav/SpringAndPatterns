package facade.objects;

import facade.facade.CarFacade;
import facade.parts.Door;
import facade.parts.Ignition;
import facade.parts.Wheel;

public class Client {

    public static void main(String[] args) {

        System.out.println("Without FACADE");
        Door door = new Door();
        door.open();

        Wheel wheel = new Wheel();
        wheel.turn();

        Ignition ignition = new Ignition();
        ignition.fire();


        System.out.println("With FACADE");
        CarFacade carFacade = new CarFacade();
        carFacade.go();


    }

}
