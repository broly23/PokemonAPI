package com.ApiPokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@EnableAutoConfiguration
@EnableCaching
@SpringBootApplication
@ComponentScan ("com.ApiPokemon")
public class Start {

	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	
	}
	
	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory("192.168.0.9", 6000);
	}

}
