package com.manikkothu.messaging.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class MessageProducerService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendDeviceListMessage(List<String> dl) {
		jmsTemplate.convertAndSend("DEV.QUEUE.1.REPLY", dl);
	}
}
