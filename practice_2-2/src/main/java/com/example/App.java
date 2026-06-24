package com.example;

public class App {

    public static String toSnakeCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String result = input.replaceAll("([A-Z]+)([A-Z][a-z])", "$1_$2");
        result = result.replaceAll("([a-z\\d])([A-Z])", "$1_$2");
        return result.toLowerCase();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: App <camelCaseString> [string2] ...");
            return;
        }

        for (String input : args) {
            System.out.println("Input      : " + input);
            System.out.println("snake_case : " + toSnakeCase(input));
            System.out.println();
        }
    }
}
