package com.example.ms17task.dp;

import com.example.ms17task.service.PaymentService;

public class MainApp {

    public static void main(String[] args) {

       /* GPServiceImpl gp = new GPServiceImpl();
        gp.doPayment();

        MilliOnServiceImpl ms = new MilliOnServiceImpl();
        ms.doPayment();*/

        /*PaymentService fm = FactoryMethod.paymentService();
        fm.doPayment();
        PaymentService fm1 = FactoryMethod.paymentService();

        fm1.doPayment();*/



        Employee employee= Employee
                .builder()
                .name("Ahmad")
                .surname("Hasanli")
                .build();


        Employee employee2= Employee
                .builder()
               // .address("A")
                .address2("A")
                .address3("A")
                .build();


    }
}
