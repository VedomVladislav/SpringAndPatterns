package by.javavedom.training.spring.abstracts.robot;

import by.javavedom.training.spring.interfaces.Hand;
import by.javavedom.training.spring.interfaces.Head;
import by.javavedom.training.spring.interfaces.Leg;
import by.javavedom.training.spring.interfaces.Robot;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseModel implements Robot {

    @Autowired
//    @Qualifier("sonyHand") //поиск по имени, без этого поиск по типу (по умолчанию)
    private Hand hand;

    @Autowired
//    @Qualifier("sonyLeg")
    private Leg leg;

    @Autowired
//    @Qualifier("sonyGoldenHead")
    private Head head;

    public BaseModel() {
        System.out.println(this + " - BaseModel constructor()");
    }

    // public BaseModel(Hand hand, Leg leg, Head head) {
    // this();
    // this.hand = hand;
    // this.leg = leg;
    // this.head = head;
    // }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Leg getLeg() {
        return leg;
    }

    public void setLeg(Leg leg) {
        this.leg = leg;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

}


