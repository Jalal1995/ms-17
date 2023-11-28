package com.example.ms17task.repository;


import com.example.ms17task.model.onetomany.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

  //  @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, value = "Client.orders")


  // @Query(value = "select c from Client c join fetch c.orders o")

 // @EntityGraph(value = "client_orders_cards")
  @EntityGraph(value = "client_orders_cards")
  List<Client> findAll();


  @EntityGraph(value = "client_orders_cards")
  Optional<Client> findById(long id);
}
