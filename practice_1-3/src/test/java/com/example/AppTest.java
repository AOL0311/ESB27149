package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testProduceCleaningRobot() {
        Robot robot = RobotFactory.produce("CleaningRobot", 30, 35, "TechCompanyA");
        assertInstanceOf(CleaningRobot.class, robot, "Should produce a CleaningRobot instance.");
    }

    @Test
    void testProduceDeliveryRobot() {
        Robot robot = RobotFactory.produce("DeliveryRobot", 120, 60, "TechCompanyB");
        assertInstanceOf(DeliveryRobot.class, robot, "Should produce a DeliveryRobot instance.");
    }

    @Test
    void testProduceUnknownTypeThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            RobotFactory.produce("UnknownRobot", 50, 50, "SomeCompany");
        }, "Unknown type should throw IllegalArgumentException.");
    }
}