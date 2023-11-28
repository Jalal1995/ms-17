package com.example.ms17task.service.impl;

import com.example.ms17task.service.Animal;

public class EaglImpl implements Animal {


    @Override
    public void fly() {
        System.out.println("Ok");
    }

    @Override
    public void run() {
        System.out.println("NOk");
    }

    @Override
    public void swim() {
        System.out.println("NOk");
    }

}
