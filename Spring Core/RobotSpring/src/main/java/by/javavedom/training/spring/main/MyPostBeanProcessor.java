package by.javavedom.training.spring.main;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostBeanProcessor implements BeanPostProcessor {

    // Участие в жизеннном цикле бина с помощью BeanPostProcessor

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean + " - postProcessBeforeInitialization()");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("Bean '" + beanName + "' created : " + bean.toString());
        return bean;
    }

}
