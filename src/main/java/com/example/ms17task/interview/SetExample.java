package com.example.ms17task.interview;


import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SetExample {


    String userName;

    public static void main(String[] args) {


        Set<SetExample> s1 = new HashSet<>();


        s1.add(new SetExample("Natiq"));
        s1.add(new SetExample("Natiq"));
        s1.add(new SetExample("Natiq"));
        s1.add(new SetExample("Elmir"));
        s1.add(new SetExample("Hasan"));


        s1.forEach(System.out::println);


    }

}
