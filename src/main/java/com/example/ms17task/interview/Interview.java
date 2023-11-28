package com.example.ms17task.interview;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Interview {


    //memory


    //1mln    heap;     1 axtar




 //   private static int age = 0;
    String username;


    @Override
    public int hashCode() {
        return 0;  //usernae
    }


    /*@Override
    public int hashCode() {
        return super.hashCode();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Interview interview = (Interview) o;
        return Objects.equals(username, interview.username);
    }


    void test1() {
        Interview i1 = new Interview();   //i1

        //
        test12();

    }

    //8gb


    //500k save to db   //200k username  //300k //200k ser


    // iphone 14,   14
    //app mac m2 40 1 (39)  //name object equals


    // user clas

    @Transactional
    void test12() {
        //ACID  --
        //save 1
        // update
    }


    public static void main(String[] args) {

        Interview i1 = new Interview("Test"); //0

        Interview i2 = new Interview("Test"); //0

        Interview i3 = new Interview("Tes5");//0

       // i3 = null;


        System.out.println(i1.equals(i3));


        Set<Interview> sets= new HashSet<>();


        sets.add(i1);
        sets.add(i2);
        sets.add(i3);


       sets.forEach(System.out::println);



        //System.out.println(i3.username);
      //  System.out.println(i3.age);


   /*
        System.out.println(i1.equals(i2)); //
        System.out.println(i2.equals(i3)); //
        String s1 = new String("Hello");
        String s2 = "Hello ";
        String s3 = s2.trim();
*/

    }


}
