package com.example.demo; 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/*
 * basePackages: Specifies the base packages where Feign clients should be scanned. 
 * In this example, com.example.demo.client is specified as the base package. 
 * Feign will scan this package and its sub-packages to discover interfaces annotated with @FeignClient.
 */
@EnableFeignClients(basePackages = "com.example.demo.client")
@SpringBootApplication
public class FeignOrderService9093Application {

	public static void main(String[] args) {
		SpringApplication.run(FeignOrderService9093Application.class, args);
	}

}
