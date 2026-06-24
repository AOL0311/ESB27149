package com.example;

public class CleaningRobot extends Robot {
    public CleaningRobot(int height, int width, String manufacturer) {
        super("CleaningRobot", height, width, manufacturer);
    }

    @Override
    public void doWork(int itemSize, int roomSize) {
        int topLeft = (roomSize - itemSize) / 2;
        for (int row = 0; row < roomSize; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < roomSize; col++) {
                if (row >= topLeft && row < topLeft + itemSize
                        && col >= topLeft && col < topLeft + itemSize) {
                    sb.append("貨");
                } else {
                    sb.append("掃");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
