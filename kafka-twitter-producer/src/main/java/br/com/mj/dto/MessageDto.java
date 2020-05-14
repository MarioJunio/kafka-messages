package br.com.mj.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MessageDto {
	
	private String id;
	private String from;
	private String to;
	private String message;
	private LocalDateTime createdDate;
}
