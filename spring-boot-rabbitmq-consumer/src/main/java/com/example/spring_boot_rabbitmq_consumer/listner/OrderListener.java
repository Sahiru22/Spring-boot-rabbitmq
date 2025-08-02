package com.example.spring_boot_rabbitmq_consumer.listner;

import com.example.spring_boot_rabbitmq_consumer.model.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {

  @RabbitListener(queues = "${rabbitmq.queue}")
  public void receive(Order order) {

    System.out.println("Order received:");
    System.out.println("Order ID: " + order.getOrderId());
    System.out.println("Product: " + order.getProduct());
    System.out.println("Quantity: " + order.getQuantity());
    System.out.println("Customer Email: " + order.getCustomerEmail());

    System.out.println("Saving order to DB...");
    System.out.println("Sending email to customer...");
  }
}
