package com.example;

public abstract class Robot {
    protected String name;
    protected int height;
    protected int width;
    protected String manufacturer;

    public Robot(String name, int height, int width, String manufacturer) {
        this.name = name;
        this.height = height;
        this.width = width;
        this.manufacturer = manufacturer;
    }

    public void introduce() {
        System.out.println("這是一台「" + name + "」，高：「" + height + "」，寬：「" + width + "」，由「" + manufacturer + "」製造。");
    }
}
