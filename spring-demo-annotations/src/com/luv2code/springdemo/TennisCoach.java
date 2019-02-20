package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
//	@Autowired
	private FortuneService fortuneService;
			
	// Spring will scan for a class that implements the FortuneService interface
//	@Autowired	
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}	

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";		 
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@Autowired
	@Qualifier("fileFortuneService") //necessário qdo existe mais de uma classe que implementa a interface
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Calling setFortuneService method");
		this.fortuneService = fortuneService;
	}
	
	// Funciona com qualquer nome de método
//	@Autowired	
//	public void doBlaBla(FortuneService fortuneService) {
//		System.out.println("Calling doBlaBla method");
//		this.fortuneService = fortuneService;
//	}	
	
	public String getEmail() {
		return email;
	}
	
	@PostConstruct
	public void initialize() {
		System.out.println("Initializing TennisCoach");
	}
	
	@PreDestroy
	public void finalize() {
		System.out.println("Finalizing TennisCoach");
	}
	
	
}
