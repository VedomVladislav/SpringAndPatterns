package decorator.decorator;

import decorator.objects.Component;

public class BorderDecorator extends Decorator {


    public BorderDecorator(Component component) {
        super(component);
    }

    public void afterDraw() {
        System.out.println("... added border");
    }

}
