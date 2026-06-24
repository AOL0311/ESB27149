package com.example;

public class App {
    public static void main(String[] args) {
        Robot cleaningRobot  = RobotFactory.produce("CleaningRobot",  30,  35, "TechCompanyA");
        Robot deliveryRobot  = RobotFactory.produce("DeliveryRobot",  120, 60, "TechCompanyB");

        cleaningRobot.introduce();
        deliveryRobot.introduce();

        System.out.println();

        int itemSize = 2;
        int roomSize = 6;

        deliveryRobot.doWork(itemSize, roomSize);

        System.out.println();

        cleaningRobot.doWork(itemSize, roomSize);
    }
}
