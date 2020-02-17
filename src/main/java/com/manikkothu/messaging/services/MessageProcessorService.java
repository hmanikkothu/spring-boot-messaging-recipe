package com.manikkothu.messaging.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessorService {

	private static final Logger logger = LoggerFactory.getLogger(MessageProcessorService.class);

	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private MessageProducerService messageProducer;
	
	@Async
	public CompletableFuture<String> process(String text) throws InterruptedException {
		
		logger.info("Started running the process method...");

		List<String> dl = deviceService.getDevices();
		messageProducer.sendDeviceListMessage(dl);
		
		return CompletableFuture.completedFuture("DONE");
	}
}
