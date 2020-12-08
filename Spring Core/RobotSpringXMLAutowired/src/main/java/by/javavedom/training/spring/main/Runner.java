package by.javavedom.training.spring.main;

import by.javavedom.training.spring.impls.pool.T1000Pool;
import by.javavedom.training.spring.impls.robot.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");

        ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
        t1000.action();

        System.out.println();
        T1000Pool t1000Pool = (T1000Pool) context.getBean("t1000Pool");
        t1000Pool.beginShow();

        ((ConfigurableApplicationContext)context).close();// закрытие контекста вручную

    }

}
