package com.example.ms17task.repository;


import com.example.ms17task.model.onetoone.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long aLong);
}
