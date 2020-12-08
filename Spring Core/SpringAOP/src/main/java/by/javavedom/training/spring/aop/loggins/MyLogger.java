package by.javavedom.training.spring.aop.loggins;

import by.javavedom.training.spring.aop.annotations.ShowResult;
import by.javavedom.training.spring.aop.annotations.ShowTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
@Aspect
public class MyLogger {

/*    public void printValue(Object obj) {
        System.out.println(obj);
    }

    public void init() {
        System.out.println("init");
    }

    public void close() {
        System.out.println("close");
    }

    public void divException() {
//        throw new ArithmeticException();
        System.out.println("/ by zero");
    }*/

    @Pointcut(value = "execution(* by.javavedom.training.spring.aop.objects.Manager.*(..))")
    private void allMethods() {
    }

//    @Around("allMethods() && @annotation(by.javavedom.training.spring.aop.annotations.ShowTime)")
    @Around(value = "allMethods() && execution(java.util.Map *(..))")
    public Object watchTime(ProceedingJoinPoint joinpoint) {
        long start = System.currentTimeMillis();
        System.out.println("method begin: " + joinpoint.getSignature().toShortString() + " >>");
        Object output = null;

        for (Object object : joinpoint.getArgs()) {
            System.out.println("Param : " + object);
        }

        try {
//            output = joinpoint.proceed(new Object[] {"c:\\temp"}); //перебитие папки сканирования
            output = joinpoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis() - start;
        System.out.println("method end: " + joinpoint.getSignature().toShortString() + ", time=" + time + " ms <<");
        System.out.println();

        return output;
    }

//    @AfterReturning(pointcut = "allMethods()", returning = "obj")
//    public void print(Object obj) {
//
//        System.out.println("Print info begin >>");
//
//        if (obj instanceof Set) {
//            Set set = (Set) obj;
//            for (Object object : set) {
//                System.out.println(object);
//            }
//
//        } else if (obj instanceof Map) {
//            Map map = (Map) obj;
//            for (Object object : map.keySet()) {
//                System.out.println("key=" + object + ", " + map.get(object));
//            }
//        }
//
//        System.out.println("Print info end <<");
//        System.out.println();
//
//    }

    @AfterReturning(pointcut = "allMethods() && execution(java.util.Map *(String)) && args(folder)", returning = "obj")
    public void printMap(Object obj, String folder) {
        Map map = (Map) obj;
        System.out.println("Folder= " + folder);
        System.out.println("Print info begin >>");
        map.forEach((k, v) -> System.out.println("Key= " + k + " Value= " + v));
        System.out.println("Print info end <<");
        System.out.println();
    }

    @AfterReturning(pointcut = "allMethods() && execution(java.util.Set *(String)) && args(folder)", returning = "obj")
    public void printSet(Object obj, String folder) {
        Set set = (Set) obj;
        System.out.println("Folder= " + folder);
        System.out.println("Print info begin >>");
        set.forEach(s -> System.out.println(s));
        System.out.println("Print info end <<");
        System.out.println();
    }

}
