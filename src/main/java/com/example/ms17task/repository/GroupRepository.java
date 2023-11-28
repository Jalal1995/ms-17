//package com.example.ms17task.repository;
//
//
//import com.example.ms17task.model.manytomany.Group;
//import com.example.ms17task.model.onetomany.Client;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.data.jpa.repository.EntityGraph;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface GroupRepository extends JpaRepository<Group, Long> {
//
//  //  @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, value = "Client.orders")
//
//
//  // @Query(value = "select c from Client c join fetch c.orders o")
//
//
//
//  List<Group> findAll();
//
//
//  @EntityGraph(value = "Client.orders")
//  Optional<Group> findById(long id);
//
//
//}
