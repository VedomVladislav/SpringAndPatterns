package factoryMethod;

//������� �� �������� ����������
public class CarSelector {

    // ��������� � ���������
    private static CarSelector instance;

    public static CarSelector getInstance() {
        if (instance == null) {
            instance = new CarSelector();
        }
        return instance;
    }

    private CarSelector() {}

    //��������� �����, ������� ������� ������ ����������
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
