package com.example.ms17task.dp;


public class Client {
    private static Client instance;

    private Client() {

    }


    public static Client getInstance() {
        if (instance == null) {
            //9
            synchronized (Client.class) {
                if (instance == null) {
                    instance = new Client();
                }
            }
        }
        return instance;
    }

}
