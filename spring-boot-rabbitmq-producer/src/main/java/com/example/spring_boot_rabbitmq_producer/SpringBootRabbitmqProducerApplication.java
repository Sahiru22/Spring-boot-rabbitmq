package com.example.spring_boot_rabbitmq_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootRabbitmqProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqProducerApplication.class, args);
	}

}
