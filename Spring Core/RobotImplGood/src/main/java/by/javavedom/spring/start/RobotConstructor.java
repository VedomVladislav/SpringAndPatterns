package by.javavedom.spring.start;

import by.javavedom.spring.objects.sony.SonyHand;
import by.javavedom.spring.objects.sony.SonyHead;
import by.javavedom.spring.objects.sony.SonyLeg;
import by.javavedom.spring.objects.toshiba.ToshibaHand;
import by.javavedom.spring.objects.toshiba.ToshibaHead;

public class RobotConstructor {

    public static void main(String[] args) {

        SonyHand sonyHand = new SonyHand();
        ToshibaHead toshibaHead = new ToshibaHead();
        SonyLeg sonyLeg = new SonyLeg();

        Robot robot1 = new Robot(sonyHand, toshibaHead, sonyLeg);
        robot1.action();

        /////////////////////////////////////////////////////////

        ToshibaHand toshibaHand = new ToshibaHand();
        SonyHead sonyHead = new SonyHead();

        Robot robot2 = new Robot(toshibaHand, sonyHead, sonyLeg);
        robot2.action();

    }

}
