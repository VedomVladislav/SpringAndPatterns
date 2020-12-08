package by.javavedom.training.spring.replacer;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ActionReplacer implements MethodReplacer {

    public Object reimplement(Object object, Method method, Object[] objects) throws Throwable {
        System.out.println("T1000 is dancing with NEW ACTION METHOD");
        return object;
    }

}
