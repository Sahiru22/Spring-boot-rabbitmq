package com.example.spring_boot_rabbitmq_consumer.model;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private String customerName;
  private Date date;
  private String deliveryAddress;
  private List<Item> orderItems;
}

