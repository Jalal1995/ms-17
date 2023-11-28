package com.example.ms17task.dp;

public class Singleton {


    public void hello() {
        System.out.println("Hello Spring boot");


        Client client = Client.getInstance();
        Client client1 = Client.getInstance();

    }
}
