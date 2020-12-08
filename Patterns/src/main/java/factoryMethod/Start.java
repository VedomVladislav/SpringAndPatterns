package factoryMethod;

public class Start {

    public static void main(String[] args) {

        Car car = CarSelector.getInstance().getCar(RoadType.CITY);
        car.drive();
        car.stop();

        car = CarSelector.getInstance().getCar(RoadType.OFF_ROAD);
        car.drive();
        car.stop();

        car = CarSelector.getInstance().getCar(RoadType.LAWN);
        car.drive();
        car.stop();

    }

}
