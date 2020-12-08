package facade.facade;

import facade.parts.Door;
import facade.parts.Ignition;
import facade.parts.Wheel;

public class CarFacade {

    private Door door = new Door();
    private Wheel wheel = new Wheel();
    private Ignition ignition = new Ignition();

    public void go() {
        door.open();
        wheel.turn();
        ignition.fire();
    }

}
