package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaConsumerApplication {

	List<String> messages = new ArrayList<>();

	User userFromTopic=null;
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg() {
		return messages;
	}

	@KafkaListener(groupId = "javatechie-1", topics = "javatechie", containerFactory = "kafkaConsumerListenerFactory")
	public List<String> getMsgFromTopic(String data) {

		messages.add(data);
		return messages;
	}
	
	
	@GetMapping("/consumeJsonMessage")
	public User consumeJsonMsg() {
		return userFromTopic;
	}
	@KafkaListener(groupId = "javatechie-2", topics = "javatechie", containerFactory = "userKafkaConsumerListenerFactory")
	public User getUserMsgFromTopic(User user) {
		userFromTopic=user;
		return userFromTopic;
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

}
