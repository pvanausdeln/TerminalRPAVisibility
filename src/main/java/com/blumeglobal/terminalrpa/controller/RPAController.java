package com.blumeglobal.terminalrpa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumeglobal.terminalrpa.service.IRPAService;
import com.blumeglobal.terminalrpa.service.impl.RPAServiceImpl;
import com.rez1.common.annotations.REZ1Logger;
import com.rez1.common.annotations.REZ1PerformanceLogger;

@RestController
@REZ1Logger
@REZ1PerformanceLogger
public class RPAController {
	
	private RPAServiceImpl myService;
	
	public static ResponseEntity<?> test(){
		

		return null;
		
	}
	
    @RequestMapping(value = "/evergreen")
    public String evergreen() {
    	try { 		
    	   myService.terminalRPAEverportLA();
    	   return "Completed!";

    	} catch (Exception ex) {
    		return ex.getMessage();
    	}
    }
    
    @RequestMapping(value = "/seattle")
    public String seattle() {
    	try { 		
     	   myService.terminalRPASeattle46();
     	   return "Completed!";

     	} catch (Exception ex) {
     		return ex.getMessage();
     	}
    }
}