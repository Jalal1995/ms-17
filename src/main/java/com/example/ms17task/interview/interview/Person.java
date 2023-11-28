package com.example.ms17task.interview.interview;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    int age=0;


    AtomicInteger age3;




    public void ageAdd() {
        age++;
      //  age3++;
        System.out.println(age);
    }

    public void ageAdd2() {
        int age=0;
        age++;
        System.out.println(age);
    }



    //3, 3,3

    public static void main(String[] args) {
        new Person().ageAdd(); // 3 thread

    }


}
