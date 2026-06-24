package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class App {
    public static void main(String[] args) {
        double result = divideAndRound(1, 3, 2);

        System.out.println("Result: " + result);
    }

    public static double divideAndRound(double a, double b, int scale) {
        BigDecimal a_BigDecimal = BigDecimal.valueOf(a);
        BigDecimal b_BigDecimal = BigDecimal.valueOf(b);

        BigDecimal result = a_BigDecimal.divide(b_BigDecimal, scale, RoundingMode.HALF_UP);

        return result.doubleValue();
    }
}
