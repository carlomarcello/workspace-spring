package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {
			"Today is your lucky day!", 
			"You'll beat everybody today!", 
			"Go there and destroy them!"};
	
	@Override
	public String getFortune() {
		Random rn = new Random();
		int index = rn.nextInt(3);
		
		return fortunes[index];
	}

}
