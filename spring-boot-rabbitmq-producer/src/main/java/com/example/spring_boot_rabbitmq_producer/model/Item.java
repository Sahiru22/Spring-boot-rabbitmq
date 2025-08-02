package com.example.spring_boot_rabbitmq_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

  private String name;
  private Integer quantity;
}