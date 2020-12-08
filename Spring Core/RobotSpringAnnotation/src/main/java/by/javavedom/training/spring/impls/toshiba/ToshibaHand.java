package by.javavedom.training.spring.impls.toshiba;

import by.javavedom.training.spring.interfaces.Hand;
import org.springframework.stereotype.Component;

@Component
public class ToshibaHand implements Hand {

    public void catchSomething() {
        System.out.println("Catched from Toshiba!");
    }

}
