package by.javavedom.training.spring.main;

import by.javavedom.training.spring.impls.pool.T1000Pool;
import by.javavedom.training.spring.impls.robot.ModelT1000;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");

        System.out.println("t1000:");
        ModelT1000 t1000 = (ModelT1000) context.getBean("t1000"); //id бина из контекста
        t1000.dance();
        t1000.action();


/*        System.out.println("\nt1000Empty:");
        ModelT1000 t1000Empty = (ModelT1000) context.getBean("t1000Empty"); //id бина из контекста
        t1000Empty.action();*/


////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*        System.out.println("\nt1000EmptyNew:");
        ModelT1000 t1000EmptyNew = (ModelT1000) context.getBean("t1000EmptyNew"); //id бина из контекста
        System.out.println("Object one: " +t1000EmptyNew.getHead());
        t1000EmptyNew.action();
        t1000EmptyNew = (ModelT1000) context.getBean("t1000EmptyNew"); //id бина из контекста
        System.out.println("Object one: " +t1000EmptyNew.getHead());
        t1000EmptyNew.action();*/


/*        System.out.println("\nWorking with CGLIB");
        RobotConveyor robotConveyor = (RobotConveyor) context.getBean("t1000Conveyor");
        Robot terminator1 = robotConveyor.createRobot();
        Robot terminator2 = robotConveyor.createRobot();
        Robot terminator3 = robotConveyor.createRobot();

        System.out.println("terminator1 " + terminator1);
        System.out.println("terminator2 " + terminator2);
        System.out.println("terminator3 " + terminator3);*/


/*        System.out.println("\nWorking with Collection");
        T1000Pool t100Pool = (T1000Pool) context.getBean("t1000Pool");
        t100Pool.action();*/

        System.out.println("\nWorking with SpEL");
        //Отбираем только тех роботов, у которых в поле color значение 'GOLD' (прописано в бине выражением SpEL)
        T1000Pool t1000GoldenPool = (T1000Pool) context.getBean("t1000ColdenPool");
        t1000GoldenPool.beginShow();


        ((ConfigurableApplicationContext) context).close();

    }

}
