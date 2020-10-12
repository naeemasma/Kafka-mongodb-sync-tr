package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.service.EventMessageDAO;
import com.example.dao.service.EventMessageDetailDAO;
import com.example.dto.EventData;
import com.example.domain.EventMessage;
import com.example.domain.EventMessageDetail;
import com.example.service.EventDataService;

@Service
public class EventDataServiceImpl implements EventDataService{

	@Autowired
	EventMessageDAO eventMessageDAO;
	@Autowired
	EventMessageDetailDAO eventMessageDetailDAO;
	
		@Override
		@Transactional
		public void createEvent(EventData eventData) {
			eventMessageDAO.save(new EventMessage(eventData.getMsgId(), eventData.getDesc()));
			eventMessageDetailDAO.save(new EventMessageDetail(eventData.getMsgId(), eventData.getContact()));			
		}

}
