package com.example.ms17task.dp;

import com.example.ms17task.service.PaymentService;
import com.example.ms17task.service.impl.GPServiceImpl;

public class FactoryMethod {

    public static PaymentService paymentService() {
        return new GPServiceImpl();
    }
}
