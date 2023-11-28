package com.example.ms17task.service.impl;

import com.example.ms17task.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service("mon")
//@Primary
public class MilliOnServiceImpl implements PaymentService {

    @Override
    public void doPayment() {
        System.out.println("mil on service");
    }

}
