package com.manikkothu.messaging.services;


import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

	private static final Logger logger = LoggerFactory.getLogger(MessageConsumerService.class);
	private final MessageProcessorService messageProcessService;
	
	public MessageConsumerService(MessageProcessorService messageProcessService) {
		this.messageProcessService = messageProcessService;
	}

	@JmsListener(destination = "DEV.QUEUE.1")
    public void consumeQueue1(TextMessage tm) {
        
        try {
        	
            String s = tm.getBody(String.class);

    		logger.info("Received DEV.QUEUE.1 - Message body - <" + s + ">");
    		logger.info("timestamp - ", System.currentTimeMillis());
    		messageProcessService.process(tm.toString());
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
