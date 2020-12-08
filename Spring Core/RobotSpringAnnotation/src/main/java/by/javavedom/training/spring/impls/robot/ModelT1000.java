package by.javavedom.training.spring.impls.robot;

import by.javavedom.training.spring.abstracts.robot.BaseModel;
import by.javavedom.training.spring.enums.ColorStyle;
import by.javavedom.training.spring.interfaces.Hand;
import by.javavedom.training.spring.interfaces.Head;
import by.javavedom.training.spring.interfaces.Leg;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import javax.inject.Inject;

@Configuration
@ComponentScan(basePackages = "by.javavedom.training.spring", scopedProxy = ScopedProxyMode.INTERFACES)
public class ModelT1000 extends BaseModel implements InitializingBean, DisposableBean {

    private ColorStyle color;
    private int year;
    private boolean soundEnabled;

    public ModelT1000() {
    }

    // public ModelT1000(Hand hand, Leg leg, Head head) {
    // super(hand, leg, head);
    // }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ModelT1000 model1() {
        return new ModelT1000();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ModelT1000 model2() {
        return new ModelT1000(ColorStyle.WHITE, 2005, true);
    }

    public ModelT1000(Hand hand, Leg leg, Head head, ColorStyle color, int year, boolean soundEnabled) {
        // super(hand, leg, head);
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public ModelT1000(ColorStyle color, int year, boolean soundEnabled) {
        this.color = color;
        this.year = year;
        this.soundEnabled = soundEnabled;
    }

    public void action() {
        getHead().calc();
        getHand().catchSomething();
        getLeg().go();
        System.out.println("color: " + color);
        System.out.println("year: " + year);
        System.out.println("can play sound: " + soundEnabled);
        System.out.println();
    }

    public void dance() {
        System.out.println("T1000 is dancing!");
    }

    public ColorStyle getColor() {
        return color;
    }

    public void setColor(ColorStyle color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    public void destroy() throws Exception {
        System.out.println(this + " - method destroy()");

    }

    public void afterPropertiesSet() throws Exception {
        System.out.println(this + " - method init()");

    }

}


