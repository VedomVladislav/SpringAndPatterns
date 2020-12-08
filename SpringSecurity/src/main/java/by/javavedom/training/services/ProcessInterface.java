package by.javavedom.training.services;

import org.springframework.security.access.annotation.Secured;

public interface ProcessInterface {

    @Secured("ROLE_ADMIN")
    String message();

}
