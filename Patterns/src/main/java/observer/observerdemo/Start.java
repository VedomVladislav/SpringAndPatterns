package observer.observerdemo;

import observer.observerdemo.publisher.Publisher;
import observer.observerdemo.subscriber.Subscriver1;
import observer.observerdemo.subscriber.Subscriver2;

public class Start {

    public static void main(String[] args) {

        Subscriver1 subscriver1 = new Subscriver1();
        Subscriver2 subscriver2 = new Subscriver2();

        Publisher publisher = new Publisher();

        publisher.addListener(subscriver1);
        publisher.addListener(subscriver2);

        publisher.createNewMessage("Welcome!");

    }

}
