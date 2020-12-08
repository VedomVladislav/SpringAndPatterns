package by.javavedom.training.spring.aop.main;

import by.javavedom.training.spring.aop.objects.FileManager;
import by.javavedom.training.spring.aop.objects.FileManager2;
import by.javavedom.training.spring.aop.objects.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FilenameFilter;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
/*        SomeService someService = (SomeService) context.getBean("someService");
//        double val = someService.getDoubleValue();

        double div = someService.getDivTwoNumbers(10, 0);*/


        FileManager fileManager = (FileManager) context.getBean("fileManager");
        FileManager2 fileManager2 = (FileManager2) context.getBean("fileManager2"); //Не выводятся методы, т.к. в срезе только интерфейс manager, класс не имплементит его

        // fileManager.getExtensionCount("c:\\Windows\\System32");
        fileManager2.getExtensionCount("c:\\Windows\\");
        fileManager.getExtensionCount("c:\\Windows\\system32\\drivers");
        // fileManager.getExtensionList("c:\\Windows\\system32\\drivers");




        ((ConfigurableApplicationContext)context).close();

    }

}
