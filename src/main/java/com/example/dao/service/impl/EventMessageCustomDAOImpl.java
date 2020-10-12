package com.example.dao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.example.dao.service.EventMessageCustomDAO;
import com.example.domain.EventMessage;
import com.mongodb.client.result.UpdateResult;

@Component
public class EventMessageCustomDAOImpl implements EventMessageCustomDAO {

	@Autowired
	 MongoOperations mongoOperations;
	
	@Override
	public long updateEventMessage(EventMessage eventMessage) {
		 UpdateResult result = mongoOperations.updateFirst(new Query().addCriteria(Criteria.where("msgId").is(eventMessage.getMsgId())), 
				 new Update().set("desc", eventMessage.getDesc().toString()), EventMessage.class);
		 return result.getModifiedCount();
	}


}
