package com.example;

import org.apache.commons.codec.digest.DigestUtils;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: App <string> [string2] ...");
            return;
        }

        for (String input : args) {
            String md5 = DigestUtils.md5Hex(input);
            System.out.println("Input : " + input);
            System.out.println("MD5   : " + md5);
            System.out.println();
        }
    }
}
