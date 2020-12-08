package by.javavedom.spring.start;

import by.javavedom.spring.objects.SonyHand;
import by.javavedom.spring.objects.SonyHead;
import by.javavedom.spring.objects.SonyLeg;

public class Robot {

    SonyHead sonyHead = new SonyHead();
    SonyHand sonyHand = new SonyHand();
    SonyLeg sonyLeg = new SonyLeg();


    void action() {
        sonyHead.calc();
        sonyHand.catchSomething();
        sonyLeg.go();
    }

}
