package com.example.ms17task.interview.interview;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@EqualsAndHashCode // false
public class Interview {

    String name;

    public static void main(String[] args) {

        Interview i1= new Interview("A");
        Interview i2= new Interview("A");


        System.out.println(i1.equals(i2)); //  true



    }

}
