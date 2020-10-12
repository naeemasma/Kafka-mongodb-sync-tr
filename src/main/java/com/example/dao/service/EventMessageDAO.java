package com.example.dao.service;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.domain.EventMessage;

public interface EventMessageDAO extends MongoRepository<EventMessage, String> {
		 
	    EventMessage findByMsgId(String msgId);
	 
	    @Query("{desc:'?0'}")
	    List<EventMessage> findEventMessageByDesc(String searchText);
	 
	    @Query("{desc : { $regex: ?0 } }")
	    List<EventMessage> findEventMessageByRegExDesc(String searchText);

}
