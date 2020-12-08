package by.javavedom.training.spring.impls.sony;

import by.javavedom.training.spring.enums.ColorStyle;
import by.javavedom.training.spring.interfaces.Head;

public class SonyHead implements Head {

	private ColorStyle color;

	public void calc(){
		System.out.println("Thinking about Sony...");
	}

	public ColorStyle getColor() {
		return color;
	}

	public void setColor(ColorStyle color) {
		this.color = color;
	}
}
