package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaPublisherConfiguration {

	// only needed if we play with raw object
	@Bean
	public ProducerFactory<String, Object> producerFactory() {
		Map<String, Object> configs = new HashMap<>();

		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		//configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		return new DefaultKafkaProducerFactory<String, Object>(configs);

	}

	// just for plain text
	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {

		return new KafkaTemplate<>(producerFactory());

	}

}
