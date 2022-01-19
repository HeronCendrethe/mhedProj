package br.com.smartbot.testesmartbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TesteSmartbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteSmartbotApplication.class, args);
	}

}
