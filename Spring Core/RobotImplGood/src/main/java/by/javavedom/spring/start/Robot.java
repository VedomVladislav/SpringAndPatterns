package by.javavedom.spring.start;

import by.javavedom.spring.objects.interfaces.Hand;
import by.javavedom.spring.objects.interfaces.Head;
import by.javavedom.spring.objects.interfaces.Leg;

public class Robot {

    Hand hand;
    Head head;
    Leg leg;

    public Robot(Hand hand, Head head, Leg leg) {
        this.hand = hand;
        this.head = head;
        this.leg = leg;
    }

    public void action() {
        head.calc();
        hand.catchSomething();
        leg.go();
    }

}
