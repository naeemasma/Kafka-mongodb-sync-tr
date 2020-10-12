package com.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class EventData {
		
		private String msgId;
		private String desc;
		private String contact;
		
		public EventData(String msgId, String desc, String contact) {
			this.msgId = msgId;
			this.desc = desc;
			this.contact = contact;
		}
	}
