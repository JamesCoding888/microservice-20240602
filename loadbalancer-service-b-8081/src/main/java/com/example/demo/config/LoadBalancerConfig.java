package com.example.demo.config;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import feign.Feign;

@Configuration
@LoadBalancerClients({
		//@LoadBalancerClient(name = "loadbalancer-service-c-9001", configuration = RoundRobinLoadBalancerConfig.class),
		@LoadBalancerClient(name = "loadbalancer-service-c-9001", configuration = RandomLoadBalancerConfig.class)
})
public class LoadBalancerConfig{
	@Bean
	@LoadBalanced
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}
}

class RoundRobinLoadBalancerConfig{
	@Bean
	public RoundRobinLoadBalancer roundRobinLoadBalancer(LoadBalancerClientFactory loadBalancerClientFactory) {
		return new RoundRobinLoadBalancer(
				loadBalancerClientFactory.getLazyProvider("loadbalancer-service-c-9001", ServiceInstanceListSupplier.class), "loadbalancer-service-c-9001");
	}
}

class RandomLoadBalancerConfig{
	@Bean
	public RandomLoadBalancer randomLoadBalancer(LoadBalancerClientFactory loadBalancerClientFactory) {
		return new RandomLoadBalancer(
				loadBalancerClientFactory.getLazyProvider("loadbalancer-service-c-9001", ServiceInstanceListSupplier.class), "loadbalancer-service-c-9001");
	}
}

