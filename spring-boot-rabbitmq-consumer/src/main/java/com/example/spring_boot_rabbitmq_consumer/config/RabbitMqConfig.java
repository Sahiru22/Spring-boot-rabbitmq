package com.example.spring_boot_rabbitmq_consumer.config;

import com.example.spring_boot_rabbitmq_consumer.model.Order;
import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

  public static final String EXCHANGE = "sales_data_exchange";
  public static final String QUEUE = "orders_queue";
  public static final String ROUTING_KEY = "customer.order";

  @Bean
  public TopicExchange salesDataExchange() {
    return new TopicExchange(EXCHANGE, true, false);
  }

  @Bean
  public Queue ordersQueue() {
    return new Queue(QUEUE, true, false, false);
  }

  @Bean
  public Binding binding() {
    return BindingBuilder
        .bind(ordersQueue())
        .to(salesDataExchange())
        .with(ROUTING_KEY);
  }

  @Bean
  public MessageConverter messageConverter() {
    Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
    jsonMessageConverter.setClassMapper(classMapper());
    return jsonMessageConverter;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(messageConverter());
    return template;
  }

  @Bean
  public DefaultClassMapper classMapper() {
    DefaultClassMapper classMapper = new DefaultClassMapper();
    Map<String, Class<?>> idClassMapping = new HashMap<>();
    idClassMapping.put("com.example.spring_boot_rabbitmq_producer.model.Order", Order.class);
    classMapper.setIdClassMapping(idClassMapping);
    return classMapper;
  }
}