package com.blumeglobal.terminalrpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumeglobal.terminalrpa.service.IRPAService;
import com.blumeglobal.terminalrpa.service.impl.RPAServiceImpl;

@Component
public class RPA implements CommandLineRunner {

	@Autowired
	private RPAServiceImpl myService;

	@Override
	public void run(String[] args) throws Exception {
		System.out.println("------------------------");
		//myService.terminalRPASeattle46();
		//myService.terminalRPAEverportLA();
	 	}
}
