package com.javaguides.springboot;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Company.class)
public class Config {
    @Bean
    public Address getAddress() {
        return new Address("High Street", 1000);
    }
    
    @Bean
    public Contact getContact() {
        return new Contact("for Contact", 4000);
    }
}