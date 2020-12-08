package by.javavedom.training.beans;

import by.javavedom.training.objects.CarInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class MainBean {

    @Autowired
    private CarInterface carImpl;

    public String getMessage() {
        return carImpl.getSound();
    }

}
