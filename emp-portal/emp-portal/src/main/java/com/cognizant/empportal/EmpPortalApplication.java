package com.cognizant.empportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
/*
 * @LoadBalanced works for RestTemplate coz LoadBalancerAutoConfiguration works directly with the RestTemplate 
 * bean opposed to ReactiveLoadBalancerAutoConfiguration which works with the builder, 
 * this due to the fact that WebClient is immutable and can't be extended after creation like RestTemplate
 * */
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
public class EmpPortalApplication {

	public void tryOne() {
		System.out.println("in tryOne");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EmpPortalApplication.class, args);
	}

	
	
	
	

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	 @Bean
	 @LoadBalanced
	 WebClient webClient(LoadBalancerClient loadBalancerClient) {
	        return WebClient.builder()
	                .filter(new LoadBalancerExchangeFilterFunction(loadBalancerClient))
	                .build();
	    }

}
