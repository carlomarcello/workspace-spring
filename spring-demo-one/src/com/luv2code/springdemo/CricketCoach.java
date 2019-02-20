package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	// define a private field for the dependency
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	// define a constructor for dependency injection
	public CricketCoach() {	
		System.out.println("CricketCoach: inside no-arg constructor");
	}	
	
	// Our setter method that will be called by Spring 
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("CricketCoach: setting fortuneService");
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: setting emailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	public void setTeam(String team) {
		System.out.println("CricketCoach: setting team");
		this.team = team;
	}	

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes practicing anything";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get a fortune
		return fortuneService.getFortune();
	}
	
	public void initialization() {
		System.out.println("initializing bean");
	}
	
	public void destruction() {
		System.out.println("destroying bean");
	}

}








