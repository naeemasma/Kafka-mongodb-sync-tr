package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.service.EventMessageCustomDAO;
import com.example.dao.service.EventMessageDAO;
import com.example.dto.EventData;
import com.example.domain.EventMessage;
import com.example.service.EventMessageService;

@Service
public class EventMessageServiceImpl implements EventMessageService{

	@Autowired
	EventMessageDAO eventMessageDAO;
	@Autowired
	EventMessageCustomDAO eventMessageCustomDAO;
	
	public void deleteAll() {
		 System.out.println("Deleting all records..");
		 eventMessageDAO.deleteAll();
		 }
		 
		 @Transactional
		 public void addSampleData() {
			 System.out.println("Adding messages");
			 EventMessage evtMsg = null;
			 for(int i=0;i<3;i++) {
				if(i==0)evtMsg = new EventMessage(i+"", "EventMessage "+i);
				else if(i==1)evtMsg = new EventMessage(i+"", "EventMessage "+i);
				else evtMsg = new EventMessage(i+"", "EventMessage "+i);
				eventMessageDAO.save(evtMsg);
			 }
		 }
		 public void update() {
			 System.out.println("Update message");
			 eventMessageCustomDAO.updateEventMessage(new EventMessage("1", "EventMessage One Updated"));
		 }
		 public void listAll() {
		 System.out.println("Listing messages");
		 eventMessageDAO.findAll().forEach(m -> System.out.println(m));
		 }
		 
		 public void findFirst() {
		 System.out.println("Finding by id");
		 EventMessage m = eventMessageDAO.findByMsgId("2");
		 System.out.println(m);
		 }
		 
		 public void findByRegex() {
		 System.out.println("Finding by Regex - All with messages starting with ^Event");
		 eventMessageDAO.findEventMessageByRegExDesc("^Event").forEach(m -> System.out.println(m));
		 }

		@Override
		public void createEvent(EventData eventData) {
			eventMessageDAO.save(new EventMessage(eventData.getMsgId(), eventData.getDesc()));			
		}

}
