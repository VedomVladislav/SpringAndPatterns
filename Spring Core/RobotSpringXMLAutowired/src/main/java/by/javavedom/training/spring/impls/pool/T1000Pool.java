package by.javavedom.training.spring.impls.pool;

import by.javavedom.training.spring.interfaces.Robot;
import by.javavedom.training.spring.interfaces.RobotPool;

import java.util.Collection;
import java.util.Map;

public class T1000Pool implements RobotPool {

    private Collection<Robot> robotCollection;

    public T1000Pool(Collection<Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }

    public Collection<Robot> getRobotCollection() {
        return robotCollection;
    }

    public void beginShow() {
        for (Robot robot : robotCollection) {
            System.out.println("------------------");
            robot.action();
        }
    }


/*    private Map<String, Robot> robotCollection;

    public T1000Pool() {
    }

    public T1000Pool(Map<String, Robot> robotCollection) {
        this.robotCollection = robotCollection;
    }


    public Map<String, Robot> getRobotCollection() {
        return robotCollection;
    }

    public void action() {
        for (Map.Entry<String, Robot> robotMap: robotCollection.entrySet()) {
            System.out.println(robotMap.getKey());
            robotMap.getValue().action();
        }
    }*/

}
