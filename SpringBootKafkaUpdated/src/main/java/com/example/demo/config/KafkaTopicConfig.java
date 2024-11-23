package com.example.demo.config;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	@Bean
	public NewTopic javaguidesTopic()
	{
		return TopicBuilder.name("javaguides").build();
		
		//return TopicBuilder.name("topicName").replicas(3).partitions(2).config(Map.of("min.insync.replicas","2")).build();
	}
	@Bean
	public NewTopic javaguidesJsonTopic()
	{
		return TopicBuilder.name("javaguides_json").build();
	}
	
}
