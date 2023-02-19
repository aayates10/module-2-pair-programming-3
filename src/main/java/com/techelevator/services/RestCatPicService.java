package com.techelevator.services;

import org.springframework.stereotype.Component;

import com.techelevator.model.CatPic;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatPicService implements CatPicService {
	RestTemplate restTemplate = new RestTemplate();
	@Override
	public CatPic getPic() {

		CatPic catPic = restTemplate.getForObject("https://cat-data.netlify.app/images/cat-with-bananas-527x600.jpg", CatPic.class);
		return catPic;
		// TODO Auto-generated method stub

	}

}	
