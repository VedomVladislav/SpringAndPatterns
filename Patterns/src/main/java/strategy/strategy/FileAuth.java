package strategy.strategy;

import java.io.File;

public class FileAuth implements AuthStrategy {

    private File file;

    public FileAuth(File file) {
        this.file = file;
    }

    public boolean checkLogin(String name, String password) {
        System.out.println("Checking from file...");
        return checkFromFile();
    }

    public boolean checkFromFile() {
        //read from file
        return true;
    }
}
