package com.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

@SpringBootApplication
public class SchoolMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolMsApplication.class, args);
//		System.out.println("hello");
		 Address address = new Address("High Street", 1000);
		 Contact contact = new Contact("For Contact", 1000);
		 new Company(address, contact);
	}
	


}
