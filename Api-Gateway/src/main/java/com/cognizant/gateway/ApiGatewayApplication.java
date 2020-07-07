package com.cognizant.gateway;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@ServletComponentScan(basePackages="com.cognizant.gateway.service")
public class ApiGatewayApplication implements ApplicationContextAware {
	private static ApplicationContext appContext;
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		/*
		 * String[] beans = appContext.getBeanDefinitionNames(); Arrays.sort(beans); for
		 * (String bean : beans) { System.out.println(bean); }
		 */
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		appContext=applicationContext;
		
	}
}
