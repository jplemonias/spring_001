package com.testjp.TestApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TestAppApplication {

	/**
	* @param args
	*/
	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
		System.out.println("API loaded !");
	}


}
