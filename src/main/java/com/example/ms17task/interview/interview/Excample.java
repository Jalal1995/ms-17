package com.example.ms17task.interview.interview;

import java.util.Random;

public class Excample {
    public static void main(String[] args) {
        try {
            method1();
            method2();
            method3();
        } catch (Exception r) {
            r.printStackTrace();
            throw new RuntimeException(" Exception" + r.getMessage());
        }

    }


    private static void method1() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException(" new runtime exception");
        }
    }

    private static void method2() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException(" new runtime exception");
        }
    }

    private static void method3() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException(" new runtime exception");
        }
    }
}
