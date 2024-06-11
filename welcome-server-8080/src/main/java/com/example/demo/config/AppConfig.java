package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import java.util.Map;
import org.springframework.boot.actuate.info.InfoContributor;
@Configuration
public class AppConfig {
	/*
	 * @FunctionalInterface
	 *	public interface InfoContributor {		
	 *		void contribute(Info.Builder builder);		
	 *	}			
	 */
	@Bean
	public InfoContributor infoContributor() {
		return (builder) -> {
			builder.withDetail("app", 
					Map.of("name","welcom-service",
							"description","To provide custom application information",
							"version", "1.0.0")
					);						
		};
	}
}
