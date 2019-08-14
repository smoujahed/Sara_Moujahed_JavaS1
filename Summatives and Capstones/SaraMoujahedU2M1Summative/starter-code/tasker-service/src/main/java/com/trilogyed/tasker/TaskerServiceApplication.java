package com.trilogyed.tasker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class TaskerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskerServiceApplication.class, args);
	}

}
