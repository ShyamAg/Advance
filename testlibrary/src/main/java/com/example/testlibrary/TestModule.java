package com.example.testlibrary;

public class TestModule {
    public static int square(int a) {
        return a * a;
    }

    public static double root(int a) {
        return Math.sqrt(a);
    }

    public static boolean checkCondition(String value) {
        return value.equalsIgnoreCase("Click Me");
    }
}
