package com.example.ms17task.dto;

import java.io.Serializable;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ClientDto implements Serializable {

    String name;
    String surname;
    Set<OrderDto> orders;
    Set<CardDto> cards;


}
