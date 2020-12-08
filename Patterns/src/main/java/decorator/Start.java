package decorator;

import decorator.decorator.BorderDecorator;
import decorator.objects.Button;
import decorator.objects.Component;
import decorator.objects.TextView;
import decorator.objects.Window;

public class Start {

    private static Component window;
    private static Component textView;
    private static Component button;

    public static void main(String[] args) {

//        Component windowWithBorder = new ColorDecorator(new BorderDecorator(new Window()));
//        windowWithBorder.draw();
//
//        Component textView = new ColorDecorator(new TextView());
//        textView.draw();


        boolean showBorder = true;

        if (!showBorder) {
            window = new Window();
            textView = new TextView();
            button = new Button();
        } else {
            window = new BorderDecorator(new Window());
            textView = new BorderDecorator(new TextView());
            button = new BorderDecorator(new Button());
        }

        window.draw();
        textView.draw();
        button.draw();

    }

}
