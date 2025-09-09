package com.bancolombia.arka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArkaApplication.class, args);
	}

}
