package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamConsumerApplication {
	
	private Logger logger=LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

	
	@StreamListener("input")
	public void consumeMsg(Book book)
	{
		logger.info("Consume Playload "+ book);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	}

}
