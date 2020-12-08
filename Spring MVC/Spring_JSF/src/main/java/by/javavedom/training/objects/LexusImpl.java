package by.javavedom.training.objects;

import org.springframework.stereotype.Component;

@Component
public class LexusImpl implements CarInterface {

    private String sound = "Lexus beep!!";

    @Override
    public String getSound() {
        return sound;
    }

}
