package by.javavedom.training.spring.impls.toshiba;


import by.javavedom.training.spring.interfaces.Head;
import org.springframework.stereotype.Component;

@Component
public class ToshibaHead implements Head {
	
	public void calc(){
		System.out.println("Thinking about Toshiba...");
	}

}
