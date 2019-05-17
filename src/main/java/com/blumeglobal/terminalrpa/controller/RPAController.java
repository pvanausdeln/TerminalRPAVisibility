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

import com.blumeglobal.terminalrpa.response.RPAResponse;
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
	
	@RequestMapping(value = "/updateLists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateLists() throws Exception {
    	myService.updateAll();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/apmLA", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> AMPLA() throws Exception {
    	myService.terminalRPA_APMLA();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/barboursHOU", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> barboursHOU() throws Exception {
    	myService.terminalRPA_Barbours();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/bayportHOU", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> bayportHOU() throws Exception {
    	myService.terminalRPA_Bayport();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
	
    @RequestMapping(value = "/evergreenLA", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> evergreen() throws Exception {
    	myService.terminalRPAEverportLA();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/evergreenOAK", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> evergreenOAK() throws Exception {
    	myService.terminalRPAEverportOAK();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/evergreenTAC", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> evergreenTAC() throws Exception {
    	myService.terminalRPAEverportTAC();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/huskyTAC", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> huskyTAC() throws Exception {
    	myService.terminalRPAHuskyTAC();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/itsLB", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> itsLB() throws Exception {
    	myService.terminalRPA_ITSLB();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/LBCT", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> LBCT() throws Exception {
    	myService.terminalRPALBCT();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Maher", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Maher() throws Exception {
    	myService.terminalRPA_Maher();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/Miami", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Miami() throws Exception {
    	myService.terminalRPA_Miami();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/NCT", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> NCT() throws Exception {
    	myService.terminalRPA_NCT();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/newark", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> PortNewark() throws Exception {
    	myService.terminalRPA_Newark();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/packer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Packer() throws Exception {
    	myService.terminalRPAPacificLB();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pacificLB", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> pacificLB() throws Exception {
    	myService.terminalRPAPacificLB();
       	RPAResponse responseObj = new RPAResponse();
       	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @GetMapping(value = "/seattle18", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> seattle18() throws Exception {
    	myService.terminalRPASeattle18();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
 	   return new ResponseEntity<>(responseObj, HttpStatus.OK);

    }
    
    @GetMapping(value = "/seattle30", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> seattle30() throws Exception {
    	myService.terminalRPASeattle30();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
 	   return new ResponseEntity<>(responseObj, HttpStatus.OK);

    }
    
    @GetMapping(value = "/seattle46", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> seattle46() throws Exception {
    	myService.terminalRPASeattle46();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
 	   return new ResponseEntity<>(responseObj, HttpStatus.OK);

    }
    
    @RequestMapping(value = "/ttiLB", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ttiLB() throws Exception {
    	myService.terminalRPA_TTILB();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/trapacJAX", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> tpJAX() throws Exception {
    	myService.terminalRPA_TPJAX();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/trapacLA", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> tpLA() throws Exception {
    	myService.terminalRPA_TPLA();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/trapacOAK", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> tpOAK() throws Exception {
    	myService.terminalRPA_TPOAK();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/wbctLA", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> wbctLA() throws Exception {
    	myService.terminalRPA_WBCTLA();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/WWT", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> WWT() throws Exception {
    	myService.terminalRPA_WWT();
    	RPAResponse responseObj = new RPAResponse();
    	responseObj.setMessage("Complete");
    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
    }
    
//    @RequestMapping(value = "/ymLA", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> ymLA() throws Exception {
//    	myService.terminalRPA_YMLA();
//    	RPAResponse responseObj = new RPAResponse();
//    	responseObj.setMessage("Complete");
//    	return new ResponseEntity<>(responseObj, HttpStatus.OK);
//    }
    
    
}