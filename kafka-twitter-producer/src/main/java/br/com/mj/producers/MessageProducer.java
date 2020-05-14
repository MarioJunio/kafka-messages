package br.com.mj.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import br.com.mj.dto.MessageDto;

@Component
public class MessageProducer {

	@Value("${topic.twitter}")
	private String twitterTopic;
	
	private final KafkaTemplate<String, MessageDto> kafkaTemplate;

	@Autowired
	public MessageProducer(KafkaTemplate<String, MessageDto> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(final MessageDto messageDto) {
		this.kafkaTemplate.send(this.twitterTopic, messageDto.getId(), messageDto);
	}
}
