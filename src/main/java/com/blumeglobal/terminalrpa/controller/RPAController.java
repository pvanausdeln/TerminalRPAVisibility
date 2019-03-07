package com.blumeglobal.terminalrpa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumeglobal.terminalrpa.Response.RPAResponse;
import com.blumeglobal.terminalrpa.service.IRPAService;
import com.blumeglobal.terminalrpa.service.impl.RPAServiceImpl;
import com.rez1.common.annotations.REZ1Logger;
import com.rez1.common.annotations.REZ1PerformanceLogger;

@RestController
@REZ1Logger
@REZ1PerformanceLogger
@CrossOrigin
public class RPAController {
	
	@Autowired
	private RPAServiceImpl myService;
	
	
	public static ResponseEntity<?> test(){
		

		return null;
		
	}
	
    @RequestMapping(value = "/evergreen", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> evergreen() throws Exception {
    	   //myService.terminalRPAEverportLA();
    	   return new ResponseEntity<>("Completed!", HttpStatus.OK);
    }
    
    @GetMapping(value = "/seattle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> seattle() throws Exception {
    	//myService.terminalRPASeattle46();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
//    	String s = "{\"x\" : \"Complete\"}";
//    	System.out.println(s);
 	   return new ResponseEntity<>(responseObj, HttpStatus.OK);

    }
}