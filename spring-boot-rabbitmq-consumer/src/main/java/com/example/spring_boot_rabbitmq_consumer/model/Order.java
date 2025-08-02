package com.example.spring_boot_rabbitmq_consumer.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order implements Serializable {

  private String orderId;
  private String product;
  private int quantity;
  private String customerEmail;
}

