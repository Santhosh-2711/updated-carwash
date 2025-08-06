package com.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(BmsApplication.class, args);
	}
}
