package by.javavedom.training.spring.impls.pool;

import by.javavedom.training.spring.interfaces.Robot;
import by.javavedom.training.spring.qualifiers.RobotType;
import by.javavedom.training.spring.enums.ColorStyle;
import org.springframework.beans.factory.annotation.Autowired;

public class T1000Pool {

    public T1000Pool() {
        System.out.println("t1000 pool constructor()");
    }

    @Autowired
    @RobotType(sound = false, color = ColorStyle.BLACK)
    private Robot blackRobot;

    @Autowired
    @RobotType(sound = true, color = ColorStyle.BLACK)
    private Robot blackSoundableRobot;

    public Robot getBlackRobot() {
        return blackRobot;
    }

    public Robot getBlackSoundableRobot() {
        return blackSoundableRobot;
    }

    public void showRobotsColors() {
        blackRobot.action();
        blackSoundableRobot.action();
    }


    //    private Collection<Robot> robotCollection;
//
//    public T1000Pool(Collection<Robot> robotCollection) {
//        this.robotCollection = robotCollection;
//    }
//
//    public Collection<Robot> getRobotCollection() {
//        return robotCollection;
//    }
//
//    public void beginShow() {
//        for (Robot robot : robotCollection) {
//            System.out.println("------------------");
//            robot.action();
//        }
//    }


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
