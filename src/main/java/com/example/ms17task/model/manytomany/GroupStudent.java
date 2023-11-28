//package com.example.ms17task.model.manytomany;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//import jakarta.persistence.Table;
//import java.util.List;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.ToString;
//import lombok.experimental.FieldDefaults;
//
//@Data
//@AllArgsConstructor
//@Builder
//@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Table(name = "t_group_student")
//@Entity
//@NoArgsConstructor
//@EqualsAndHashCode
//
///*@NamedEntityGraph(
//        name = "Customer.orders",
//        attributeNodes = @NamedAttributeNode("orders")
//)*/
//public class GroupStudent {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;
//    String name;
//    String surname;
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "id", nullable = false)
//    @JsonBackReference
//    List<Group> groups;
//}
