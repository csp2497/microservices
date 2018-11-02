package com.example.hellobootdiscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorService {

	@Autowired
	RestTemplate restTemplate;

	public CalculatorService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String add(int n1, int n2) {
		String response = restTemplate.getForObject("http://calculator:8080/add/{n1}/{n2}", String.class, n1, n2);
		log.info("Response:{}", response);
		return response;
	}
}
