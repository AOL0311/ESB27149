package com.example;

public class App {
    public static void main(String[] args) {
        Robot cleaningRobot = RobotFactory.produce("掃地機器人", 30, 35, "科技公司A");
        Robot deliveryRobot = RobotFactory.produce("送貨機器人", 120, 60, "科技公司B");

        cleaningRobot.introduce();
        deliveryRobot.introduce();
    }
}
