package by.javavedom.training.spring.impls.toshiba;

import by.javavedom.training.spring.interfaces.Leg;
import org.springframework.stereotype.Component;

@Component
public class ToshibaLeg implements Leg {
	
	public void go(){
		System.out.println("Go to Toshiba!");
	}

}
