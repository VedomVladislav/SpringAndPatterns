package factoryMethod;

//фабрика по созданию автомобиля
public class CarSelector {

    // совмещаем с сингтоном
    private static CarSelector instance;

    public static CarSelector getInstance() {
        if (instance == null) {
            instance = new CarSelector();
        }
        return instance;
    }

    private CarSelector() {}

    //фабричный метод, который создает нужный автомобиль
    public Car getCar(RoadType roadType) {
        Car car = null;
        switch (roadType) {
            case CITY:
                car = new Porsche();
                System.out.println("Cadillac");
                break;
            case OFF_ROAD:
                car = new Jeep();
                System.out.println("Jeep");
                break;
            case LAWN:
                car = new NewJeep();
                System.out.println("NewJeep");
                break;
        }
        return car;
    }

}
