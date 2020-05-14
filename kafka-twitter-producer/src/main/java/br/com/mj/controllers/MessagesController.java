package br.com.mj.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mj.dto.MessageDto;
import br.com.mj.producers.MessageProducer;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/messages")
@Slf4j
public class MessagesController {
	
	private MessageProducer messageProducer;
	
	@Autowired
	public MessagesController(MessageProducer messageProducer) {
		this.messageProducer = messageProducer;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public void processar(@RequestBody MessageDto messageDto) {
		messageDto.setId(UUID.randomUUID().toString());
		this.messageProducer.send(messageDto);
		
		log.info("Mensagem enviada: " + messageDto.toString());
	}
}
