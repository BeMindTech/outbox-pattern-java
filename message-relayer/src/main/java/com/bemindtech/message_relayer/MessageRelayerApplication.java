package com.bemindtech.message_relayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MessageRelayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageRelayerApplication.class, args);
	}

}
