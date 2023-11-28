package com.example.ms17task.repository;


import com.example.ms17task.model.onetomany.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientPageAndSortingRepository extends PagingAndSortingRepository<Client, Long> {


 @EntityGraph(value = "client_orders_cards")
 Page<Client> findAll(Pageable pageable);

}
