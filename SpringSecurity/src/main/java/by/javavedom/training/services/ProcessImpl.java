package by.javavedom.training.services;

import org.springframework.stereotype.Service;

@Service("process")
public class ProcessImpl implements ProcessInterface {

    @Override
    public String message() {
        return "My message";
    }
}
