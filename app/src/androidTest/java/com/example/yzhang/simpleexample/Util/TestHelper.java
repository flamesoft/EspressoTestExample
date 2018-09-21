package com.example.yzhang.simpleexample.Util;

public class TestHelper {

    public static void sleep(long millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
