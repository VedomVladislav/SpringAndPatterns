package by.javavedom.training.spring.aop.objects;

import org.springframework.stereotype.Component;

@Component
public class SomeService {

    double div;

    public int getIntValue() {
        return 5;
    }

    public double getDoubleValue() {
        return 5.6;
    }

    public double getDivTwoNumbers(double a, double b) {
        try {
           div =  a/b;
        } catch (ArithmeticException e) {
            e.getMessage();
            throw new ArithmeticException();
        }
        return div;
    }


}
