package br.com.mj.consumers;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.mj.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TwitterConsumer {

	@KafkaListener(topics = "${topic.twitter}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeMessages(ConsumerRecord record) {
		log.info("Twitt: " + ((MessageDto) record.value()).toString());
	}
}
