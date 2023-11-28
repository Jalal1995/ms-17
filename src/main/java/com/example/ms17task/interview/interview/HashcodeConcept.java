package com.example.ms17task.interview.interview;

public class HashcodeConcept {

    public static void main(String... hashcodeExample) {

        Simpson homer = new Simpson(1, "Homer");
        Simpson bart = new Simpson(2, "Homer");

        boolean isHashcodeEquals = homer.hashCode() == bart.hashCode();

        if (isHashcodeEquals) {
            System.out.println("Should compare with equals method too.");
        } else {
            System.out.println("Should not compare with equals method because " +
                    "the id is different, that means the objects are not equals for sure.");
        }

    }
}
