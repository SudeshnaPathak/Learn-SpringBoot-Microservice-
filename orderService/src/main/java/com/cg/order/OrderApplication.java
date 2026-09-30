package com.cg.order;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}

//	@Bean
//	@LoadBalanced
//	public RestClient.Builder lbRestClientBuilder() {
//		return RestClient.builder();
//	}
//
//	@Bean
//	@Primary
//	public RestClient.Builder directRestClientBuilder() {
//		return RestClient.builder();
//	}
//
//	@Bean
//	@Primary
//	public RestClient serviceRestClient(
//			@Qualifier("lbRestClientBuilder") RestClient.Builder builder) {
//
//		return builder.baseUrl("http://provider").build();
//	}
//
//	@Bean
//	public RestClient directRestClient(
//			@Qualifier("directRestClientBuilder") RestClient.Builder builder) {
//
//		return builder.build();
//	}
}
