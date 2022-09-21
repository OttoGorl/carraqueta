package com.carraqueta.carraqueta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class CarraquetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarraquetaApplication.class, args);
	}

}
