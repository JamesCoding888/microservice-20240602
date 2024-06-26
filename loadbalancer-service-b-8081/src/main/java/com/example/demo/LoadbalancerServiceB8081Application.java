package com.example.demo;
import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;
@EnableFeignClients
@SpringBootApplication
@EnableRetry
public class LoadbalancerServiceB8081Application {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalancerServiceB8081Application.class, args);
	}

}
