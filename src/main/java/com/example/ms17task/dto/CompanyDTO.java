package com.example.ms17task.dto;


import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyDTO {
    String name;
    String address;
    String tin;
    Long employeeSize;
    String activityField;
    LocalDate release;
    String vision;
    String mission;
}
