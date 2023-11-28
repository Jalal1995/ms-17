package com.example.ms17task.controller;


import com.example.ms17task.dto.CustomerDTO;
import com.example.ms17task.model.onetoone.Customer;
import com.example.ms17task.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/id/{id}")
    public CustomerDTO getById(@PathVariable long id,
                               @RequestHeader String channel ) {

        if (channel.equals("web")) {
            return customerService.findById(id);
        } else {
            return new CustomerDTO();
        }

    }


    @GetMapping("{id}")
    public Customer getByIdw(@PathVariable long id) {
        return customerService.findByIds(id);
    }


    @PostMapping("/save")
    public CustomerDTO save(@RequestBody CustomerDTO customerDTO) {
        return customerService.save(customerDTO);
    }


}
