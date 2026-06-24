package com.example;

public class RobotFactory {
    public static Robot produce(String type, int height, int width, String manufacturer) {
        switch (type) {
            case "掃地機器人":
                return new CleaningRobot(height, width, manufacturer);
            case "送貨機器人":
                return new DeliveryRobot(height, width, manufacturer);
            default:
                throw new IllegalArgumentException("未知的機器人類型：" + type);
        }
    }
}
