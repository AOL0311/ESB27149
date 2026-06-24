package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testProduceCleaningRobot() {
        Robot robot = RobotFactory.produce("掃地機器人", 30, 35, "科技公司A");
        assertInstanceOf(CleaningRobot.class, robot, "應產生 CleaningRobot 實例。");
    }

    @Test
    void testProduceDeliveryRobot() {
        Robot robot = RobotFactory.produce("送貨機器人", 120, 60, "科技公司B");
        assertInstanceOf(DeliveryRobot.class, robot, "應產生 DeliveryRobot 實例。");
    }

    @Test
    void testProduceUnknownTypeThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            RobotFactory.produce("未知機器人", 50, 50, "某公司");
        }, "未知類型應拋出 IllegalArgumentException。");
    }
}