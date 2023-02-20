package com.techelevator.services;

import com.techelevator.model.CatCard;
import org.springframework.http.*;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;


import org.springframework.web.client.RestTemplate;



@Component
public class RestCatFactService implements CatFactService {
	public static final String API_BASE_URL = " http://localhost:8080";
	public static final String FACT_URL  = "https://cat-data.netlify.app/api/facts/random";
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		//String urlFact  = API_BASE_URL + FACT_URL;
		CatFact catFact = restTemplate.getForObject(FACT_URL, CatFact.class);
		// TODO Auto-generated method stub
		return catFact;

	}

}
