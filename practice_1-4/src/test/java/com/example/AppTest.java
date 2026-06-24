package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }

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

    @Test
    void testDeliveryRobotDoWork() {
        Robot robot = RobotFactory.produce("DeliveryRobot", 120, 60, "TechCompanyB");
        robot.doWork(2, 6);
        String output = outContent.toString();
        assertTrue(output.contains("Delivering a 2x2 item into a 6x6 room"),
                "Should mention item size and room size.");
        assertTrue(output.contains("center (3, 3)"),
                "Should mention center position.");
        assertTrue(output.contains("columns 2~3") && output.contains("rows 2~3"),
                "Should mention correct occupied range.");
    }

    @Test
    void testCleaningRobotDoWorkGrid() {
        Robot robot = RobotFactory.produce("CleaningRobot", 30, 35, "TechCompanyA");
        robot.doWork(2, 6);
        String output = outContent.toString();
        String[] lines = output.split(System.lineSeparator());
        assertEquals(6, lines.length, "Grid should have 6 rows for a 6x6 room.");
        assertEquals("掃掃掃掃掃掃", lines[0]);
        assertEquals("掃掃掃掃掃掃", lines[1]);
        assertEquals("掃掃掃掃掃掃", lines[4]);
        assertEquals("掃掃掃掃掃掃", lines[5]);
        assertEquals("掃掃貨貨掃掃", lines[2]);
        assertEquals("掃掃貨貨掃掃", lines[3]);
    }

    @Test
    void testCleaningRobotDoWorkOddRoom() {
        Robot robot = RobotFactory.produce("CleaningRobot", 30, 35, "TechCompanyA");
        robot.doWork(3, 9);
        String output = outContent.toString();
        String[] lines = output.split(System.lineSeparator());
        assertEquals(9, lines.length, "Grid should have 9 rows for a 9x9 room.");
        assertEquals("掃掃掃掃掃掃掃掃掃", lines[0]);
        assertEquals("掃掃掃貨貨貨掃掃掃", lines[3]);
        assertEquals("掃掃掃掃掃掃掃掃掃", lines[8]);
    }
}