package com.example.dbserver.DBDataServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages="com.example.dbserver.DBDataServer.repository")
public class DbDataServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbDataServerApplication.class, args);
	}

}
