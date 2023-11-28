package com.example.ms17task.service;

import com.example.ms17task.dto.CustomerDTO;
import com.example.ms17task.model.onetoone.Customer;

public interface CustomerService {

    CustomerDTO findById(long id);

    Customer findByIds(long id);


    CustomerDTO save(CustomerDTO customerDTO);
}
