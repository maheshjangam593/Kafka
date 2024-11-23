package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "javatechie";

	@GetMapping("/publish/{name}")
	public String getName(@PathVariable String name) {
		template.send(topic, "Hello " + name);
		return "published successfully";
	}

	@GetMapping("/publishJson")
	public String getName() {

		User user = new User(123, "Mahesh", new String[] { "ram", "sita" });
		template.send(topic, user);

		return "published Json successfully";

	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}
