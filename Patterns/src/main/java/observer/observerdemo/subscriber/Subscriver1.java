package observer.observerdemo.subscriber;

public class Subscriver1 implements  PublisherActionListener {

    public void doAction(String message) {
        System.out.println(message + " from "+ this.getClass().getName());
    }

}
