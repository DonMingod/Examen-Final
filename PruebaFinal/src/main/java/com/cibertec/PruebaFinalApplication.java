package com.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement 
@SpringBootApplication(scanBasePackages = {"com.cibertec", "com.Repository"})
public class PruebaFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaFinalApplication.class, args);
	}

}
