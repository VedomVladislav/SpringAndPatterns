package by.javavedom.training.spring.exeptions;

import org.springframework.dao.DataAccessException;

public class MyExeption extends DataAccessException {

    private static final long serialVersionUID = 5394203711238298583L;

    public MyExeption(String msg) {
        super(msg);
    }
}
