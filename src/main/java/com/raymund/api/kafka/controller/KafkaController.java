package com.raymund.api.kafka.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.raymund.api.kafka.service.KafkaProducer;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	private final KafkaProducer kafkaProducer;

	public KafkaController(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	@PostMapping("/send")
	public String sendMessage(@RequestParam String topic, @RequestParam String message) {
		kafkaProducer.sendMessage(topic, message);
		return "訊息已發送到主題：" + topic;
	}
}
