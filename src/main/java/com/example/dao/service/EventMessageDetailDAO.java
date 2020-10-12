package com.example.dao.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import com.example.domain.EventMessageDetail;

public interface EventMessageDetailDAO extends MongoRepository<EventMessageDetail, String> {
		 
	    EventMessageDetail findByMsgId(String msgId);
}
