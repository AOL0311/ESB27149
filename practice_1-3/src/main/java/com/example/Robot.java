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
        System.out.println("This is a " + name + ", height: " + height + ", width: " + width + ", manufactured by " + manufacturer + ".");
    }
}
