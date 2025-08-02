package com.example.spring_boot_rabbitmq_producer.producer;

import com.example.spring_boot_rabbitmq_producer.model.Item;
import com.example.spring_boot_rabbitmq_producer.model.Order;
import java.util.Arrays;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {

  private final RabbitTemplate rabbitTemplate;

  private static final String EXCHANGE = "sales_data_exchange";
  private static final String ROUTING_KEY = "customer.order";

  @Scheduled(fixedRate = 1000)
  public void publishOrder() {
    Order order = generateOrder();
    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, order);
    log.info("Published Order: {}", order);
  }

  private Order generateOrder() {
    return new Order(
        "Sahiru Balasooriya",
        new Date(),
        "No 07, Colombo",
        Arrays.asList(
            new Item("Laptop", 1),
            new Item("Memory Card", 1),
            new Item("Charger", 1)
        )
    );
  }
}
