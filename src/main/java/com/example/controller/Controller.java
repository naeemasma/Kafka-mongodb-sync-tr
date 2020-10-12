package com.example.controller;

import com.example.dto.EventData;
import com.example.service.event.processor.EventProcessor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class Controller {
	
	@Value("${app.consumer.subscribed-to.topic}")
	private String topicToPublish;
		
    private final EventProcessor eventProcessor;

    @Autowired
    Controller(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }
    
    @PostMapping("/send/message")
	public ResponseEntity<Object> sendEventMessage(
			@RequestBody List<EventData> events) {
    	this.eventProcessor.sendEventMessage(topicToPublish, events);
	   return new ResponseEntity<>("Event is stored successfully", HttpStatus.CREATED);
	}
}