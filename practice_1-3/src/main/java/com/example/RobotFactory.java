package com.example;

public class RobotFactory {
    public static Robot produce(String type, int height, int width, String manufacturer) {
        switch (type) {
            case "CleaningRobot":
                return new CleaningRobot(height, width, manufacturer);
            case "DeliveryRobot":
                return new DeliveryRobot(height, width, manufacturer);
            default:
                throw new IllegalArgumentException("Unknown robot type: " + type);
        }
    }
}
