package by.javavedom.training.spring.main;

import by.javavedom.training.spring.impls.pool.T1000Pool;
import by.javavedom.training.spring.impls.robot.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
//
//        ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
//        t1000.action();
//
//        T1000Pool t1000Pool = (T1000Pool) context.getBean("t1000Pool");
//        t1000Pool.showRobotsColors();


//        ModelT1000 modelT1000 = (ModelT1000) context.getBean("modelT1000"); //берет класс по имени с маленькой буквы
//        modelT1000.action();
        ModelT1000 model1 = (ModelT1000) context.getBean("model1");
        ModelT1000 model2 = (ModelT1000) context.getBean("model2");
        // ModelT1000 model3 = (ModelT1000) context.getBean("model1");
        model1.action();
        model2.action();
        // System.out.println(model3);

        ((ConfigurableApplicationContext)context).close();



    }

}
