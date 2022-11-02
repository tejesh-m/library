package com.exp.Kafkaconsumer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.exp.Kafkaconsumer.models.Book;

@Service
public class KafkaConsumerListener {
	private static final String topic="topic-demo";
	
	@KafkaListener(topics = topic,groupId="group_id", containerFactory = "userKafkaListenerFactory")
	public void consumeJson(Book book) {
		System.out.println("Consumed JSON Message:" +book);
		
	}

}
