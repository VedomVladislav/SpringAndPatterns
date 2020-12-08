package abstractFactory.start;

import abstractFactory.factory.impl.RussianFactory;
import abstractFactory.factory.impl.USAFactory;
import abstractFactory.factory.interfaces.TransportFactory;

import java.util.Scanner;

public class Start {

    private static TransportFactory factory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose factory (1 - RUS, 2 - USA): ");
        int choose = scanner.nextInt();

        if (choose == 1) {
            factory = new RussianFactory();
        } else {
            factory = new USAFactory();
        }

        factory.createCar().drive();
        factory.createAircraft().flight();
        factory.createCar().stop();

    }

}
