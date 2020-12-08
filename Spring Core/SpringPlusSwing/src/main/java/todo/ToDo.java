package todo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ToDo {
    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.launch();

//        ApplicationContext context = new ClassPathXmlApplicationContext("app-context-annotations.xml");
//        Launcher launcher = (Launcher) context.getBean("launcher");
//        launcher.launch();


    }
}