package com.example.ms17task.service.impl;

import com.example.ms17task.dto.CustomerDTO;
import com.example.ms17task.model.onetoone.Customer;
import com.example.ms17task.repository.CustomerRepository;
import com.example.ms17task.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepository customerRepository;

    private final ModelMapper modelMapper;

    @Override
    @SneakyThrows
    public CustomerDTO findById(long id) {
      /*Optional<Customer> customer = customerRepository.findByIds(id);
        CustomerDTO customerDTO = customerMapper.customerToCusDTO(customer.get());

      */


        Thread.sleep(2000);
        return customerRepository.findById(id).map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .orElseThrow(() -> new RuntimeException("not found"));

    }

    @Override
    public Customer findByIds(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {


        Customer customer= modelMapper.map(customerDTO, Customer.class);

        customer.getCustomerDetail().setCustomer(customer);


        customerRepository.save(customer);


        return null;
    }
}
