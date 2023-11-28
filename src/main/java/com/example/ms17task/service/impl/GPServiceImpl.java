package com.example.ms17task.service.impl;

import com.example.ms17task.service.PaymentService;
import org.springframework.stereotype.Service;


@Service("gp")
public class GPServiceImpl implements PaymentService {

    @Override
    public void doPayment() {
        System.out.println("Golden Pay service");
    }
}
