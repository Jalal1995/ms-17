package com.example.ms17task.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    String studentName;
    String surname;
    String address;
    int age;
}
