package todo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public void launch() {
        String[] contextPaths = new String[] {"app-context-annotations.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

}