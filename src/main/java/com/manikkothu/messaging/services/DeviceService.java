package com.manikkothu.messaging.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class DeviceService {

	private static final Logger logger = LoggerFactory.getLogger(DeviceService.class);
		
	public List<String> getDevices() throws InterruptedException {
		logger.info("getDevices");
		
		List<String> d = new ArrayList<String>();
		d.add("PIXEL4X64QD1");
		
		// Simulate processing delay
		Thread.sleep(1000L);
		
		return d;
	}
	
}
