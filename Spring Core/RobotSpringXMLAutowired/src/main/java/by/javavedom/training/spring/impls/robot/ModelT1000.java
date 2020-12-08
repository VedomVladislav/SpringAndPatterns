package by.javavedom.training.spring.impls.robot;

import by.javavedom.training.spring.abstracts.robot.BaseModel;
import by.javavedom.training.spring.interfaces.Hand;
import by.javavedom.training.spring.interfaces.Head;
import by.javavedom.training.spring.interfaces.Leg;
import by.javavedom.training.spring.interfaces.Robot;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ModelT1000 extends BaseModel implements Robot, InitializingBean, DisposableBean {

    private String color;
    private int year;
    private boolean soundEnable;

    public ModelT1000() {
    }

    public ModelT1000(Hand hand, Leg leg, Head head) {
        super(hand, leg, head);
    }

    public ModelT1000(Hand hand, Leg leg, Head head, String color, int year, boolean soundEnable) {
        super(hand, leg, head);
        this.color = color;
        this.year = year;
        this.soundEnable = soundEnable;
    }

    public ModelT1000(String color, int year, boolean soundEnable) {
        this.color = color;
        this.year = year;
        this.soundEnable = soundEnable;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnable() {
        return soundEnable;
    }

    public void setSoundEnable(boolean soundEnable) {
        this.soundEnable = soundEnable;
    }

    public void action() {
        getHead().calc();
        getHand().catchSomething();
        getLeg().go();
        System.out.println("color: " + color);
        System.out.println("year: " + year);
        System.out.println("can play sound: " + soundEnable);
    }

    public void dance() {
        System.out.println("T1000 is dancing!");
    }

//    private void initObject() {
//        System.out.println("init");
//    }
//
//    private void destroyObject() {
//        System.out.println("destroy");
//    }


    public void destroy() throws Exception {
        System.out.println(this + " - method destroy()");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(this + " - method init()");

    }

}
