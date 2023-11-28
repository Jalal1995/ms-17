//package com.example.ms17task.model.manytomany;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
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
//@Table(name = "t_group")
//@Entity
//@NoArgsConstructor
//@EqualsAndHashCode
//
///*@NamedEntityGraph(
//        name = "Customer.orders",
//        attributeNodes = @NamedAttributeNode("orders")
//)*/
//public class Group {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    Long id;
//    String name;
//    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "groups", fetch = FetchType.LAZY)
//    List<GroupStudent> groupStudents;
//
//}
