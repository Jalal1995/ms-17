package com.example.ms17task.model.onetoone;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class CustomerDetail {
    @Id
    @Column(name = "id", nullable = false)
    Long id;
    String homePhone;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonBackReference
    Customer customer;



}
