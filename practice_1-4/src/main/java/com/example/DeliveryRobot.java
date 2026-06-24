package com.example;

public class DeliveryRobot extends Robot {
    public DeliveryRobot(int height, int width, String manufacturer) {
        super("DeliveryRobot", height, width, manufacturer);
    }

    @Override
    public void doWork(int itemSize, int roomSize) {
        int topLeft = (roomSize - itemSize) / 2;
        int center  = roomSize / 2;
        System.out.println("[DeliveryRobot] Delivering a " + itemSize + "x" + itemSize
                + " item into a " + roomSize + "x" + roomSize + " room.");
        System.out.println("[DeliveryRobot] Item placed at center (" + center + ", " + center + "), "
                + "occupying columns " + topLeft + "~" + (topLeft + itemSize - 1)
                + " and rows " + topLeft + "~" + (topLeft + itemSize - 1) + ".");
    }
}
