package com.example;

public class App {
    public static void main(String[] args) {
        Robot cleaningRobot = RobotFactory.produce("CleaningRobot", 30, 35, "TechCompanyA");
        Robot deliveryRobot = RobotFactory.produce("DeliveryRobot", 120, 60, "TechCompanyB");

        cleaningRobot.introduce();
        deliveryRobot.introduce();
    }
}
