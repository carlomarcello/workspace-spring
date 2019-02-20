package com.luv2code.springdemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
	
	private String[] fortunes;
	
	public FileFortuneService() {		
	}
		
	@Override
	public String getFortune() {
		Random rn = new Random();
		int index = rn.nextInt(fortunes.length);		
		return fortunes[index];
	}
	
	@PostConstruct
	public void initialize() {
		// A lógica desse método poderia ter ficado no construtor
		
		File file = new File(getClass().getClassLoader().getResource("fortunes.txt").getFile());
		Path path = Paths.get(file.getPath());
		
		ArrayList<String> msgs = new ArrayList<String>();
		
		try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(s -> msgs.add(s));
        } catch (IOException ex) {
        	System.err.println(ex);
        }		
				
		String[] msgsArr = new String[msgs.size()];
		fortunes = msgs.toArray(msgsArr);
	}

}
