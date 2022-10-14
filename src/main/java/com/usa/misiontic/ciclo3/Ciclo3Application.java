package com.usa.misiontic.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;

@EntityScan(basePackages = {"com.usa.misiontic.ciclo3.entities"})
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}
    }
