package com.example.service;

import com.example.dto.EventData;

public interface EventMessageService {
	void deleteAll();
    void addSampleData();
    void update();
    void listAll();
    void findFirst();
    void findByRegex();
    void createEvent(EventData eventData);

}
