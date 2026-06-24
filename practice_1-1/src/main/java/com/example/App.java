package com.example;

public class App {
    public static void main(String[] args) {
        double result = divideAndRound(1, 3, 2);

        System.out.println("Result: " + result);
    }

    public static double divideAndRound(double a, double b, int scale) {
        double rawResult = a / b;
        double factor = Math.pow(10, scale);

        return Math.round(rawResult * factor) / factor;
    }
}
