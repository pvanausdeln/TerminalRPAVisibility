package com.blumeglobal.terminalrpa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.blumeglobal.terminalrpa.service.IRPAService;
import com.rez1.common.annotations.REZ1Logger;
import com.rez1.common.annotations.REZ1PerformanceLogger;

@RestController
@REZ1Logger
@REZ1PerformanceLogger
public class RPAController {
	
	public static ResponseEntity<?> test(){
		

		return null;
		
	}
}