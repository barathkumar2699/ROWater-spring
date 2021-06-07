package com.example.ROWater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class RoWaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoWaterApplication.class, args);
	}

}
