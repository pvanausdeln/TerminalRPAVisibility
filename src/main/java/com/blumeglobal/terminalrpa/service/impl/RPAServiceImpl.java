package com.blumeglobal.terminalrpa.service.impl;

import java.util.List;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.blumeglobal.terminalrpa.dao.repositories.RPARepository;
import com.blumeglobal.terminalrpa.model.IRPAQuery;


/**
 * The ShipmentScheduleServiceImpl implements to manage the shipment schedules.
 *
 */

@Service
public class RPAServiceImpl{

	@Autowired
	RPARepository rpaRepository;
	
	public void terminalRPA_APMLA() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.APMLASearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "APMLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\APMLA\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_Barbours() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.BarboursSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "WBCTLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\BarboursHOU\\WBCTLA\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_Bayport() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.BayportSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "WBCTLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\BayportHOU\\Main.xaml\"");
		}
	}
	
	public void terminalRPAEverportLA() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.EverportLASearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "EvergreenPortLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\EvergreenPortLA\\Main.xaml\"");
		}
	}
	
	public void terminalRPAEverportOAK() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.EverportOAKSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "EvergreenPortOAK");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\EvergreenPortOAK\\Main.xaml\"");
		}
	}
	
	public void terminalRPAEverportTAC() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.EverportTACSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "EvergreenPortTAC");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\EvergreenPortTAC\\Main.xaml\"");
		}
	}
	
	public void terminalRPAHuskyTAC() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.HuskyTACSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "HuskyTAC");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\HuskyTAC\\Main.xaml\"");
		}
	}
	
	public void terminalRPALBCT() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.LBCTSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "LBCT");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\LBCT\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_NCT() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.NCTSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "NCT");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\NCT\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_Newark() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.NewarkSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "WBCTLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\PortNewark\\Main.xaml\"");
		}
	}
	
	public void terminalRPAPacificLB() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.PacificLBSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "PacificLB");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\PacificLB\\Main.xaml\"");
		}
	}
	
	public void terminalRPASeattle18() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.SeattleT18Search();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "SeattleTerminal18");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\SeattleTerminal18\\Main.xaml\"");
		}
	}
	
	public void terminalRPASeattle30() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.SeattleT30Search();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "SeattleTerminal30");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\SeattleTerminal30\\Main.xaml\"");
		}
	}
	
	public void terminalRPASeattle46() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.SeattleT46Search();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "SeattleTerminal46");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\SeattleTerminal46\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_TPLA() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.TPLASearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "TPLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\TPLA\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_TPOAK() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.TPOAKSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "TPOAK");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\TPOAK\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_WBCTLA() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.WBCTLASearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "WBCTLA");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\WBCTLA\\Main.xaml\"");
		}
	}
	
	public void terminalRPA_WWT() throws Exception {
		List<IRPAQuery> excel = null;
		excel = rpaRepository.WWTSearch();
		if(excel == null) {
			System.out.println("Query failed for some reason");
			System.exit(1);
		}
		else {
			createExcel(excel, "WWT");
			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\WWT\\Main.xaml\"");
		}
	}
	
	public void updateAll() throws Exception {
		createExcel(rpaRepository.APMLASearch(), "APMLA");
		createExcel(rpaRepository.BarboursSearch(), "BarboursHOU");
		createExcel(rpaRepository.BayportSearch(), "BayportHOU");
		createExcel(rpaRepository.EverportLASearch(), "EvergreenPortLA");
		createExcel(rpaRepository.EverportOAKSearch(), "EvergreenPortOAK");
		createExcel(rpaRepository.EverportTACSearch(), "EvergreenPortTAC");
		createExcel(rpaRepository.HuskyTACSearch(), "HuskyTAC");
		createExcel(rpaRepository.LBCTSearch(), "LBCT");
		createExcel(rpaRepository.NCTSearch(), "NCT");
		createExcel(rpaRepository.NewarkSearch(), "PortNewark");
		createExcel(rpaRepository.PacificLBSearch(), "PacificLB");
		createExcel(rpaRepository.SeattleT18Search(), "SeattleTerminal18");
		createExcel(rpaRepository.SeattleT30Search(), "SeattleTerminal30");
		createExcel(rpaRepository.SeattleT46Search(), "SeattleTerminal46");
		//createExcel(rpaRepository.TCTSearch(), "TCT");
		createExcel(rpaRepository.TPLASearch(), "TPLA");
		createExcel(rpaRepository.TPOAKSearch(), "TPOAK");
		createExcel(rpaRepository.WBCTLASearch(), "WBCTLA");
		createExcel(rpaRepository.WWTSearch(), "WWT");
		//createExcel(rpaRepository.YMLASearch(), "YMLA");
	}
	
//	public void terminalRPA_YMLA() throws Exception {
//		List<IRPAQuery> excel = null;
//		excel = rpaRepository.YMLASearch();
//		if(excel == null) {
//			System.out.println("Query failed for some reason");
//			System.exit(1);
//		}
//		else {
//			createExcel(excel, "YMLA");
//			Runtime.getRuntime().exec("\"C:\\Users\\pvanausdeln\\AppData\\Local\\UiPath\\app-19.3.0\\UiRobot.exe\" /file:\"C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\YMLA\\Main.xaml\"");
//		}
//	}
	
	public void createExcel(List<IRPAQuery> excel, String dir) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet spreadsheet = workbook.createSheet("Sheet1");
	    Row header = spreadsheet.createRow(0);
	    header.createCell(0).setCellValue("Equipment Number");
	    header.createCell(1).setCellValue("Vessel");
	    header.createCell(2).setCellValue("Voyage");
	    header.createCell(3).setCellValue("WONumber");
	    header.createCell(4).setCellValue("ReferenceNumber");
	    header.createCell(5).setCellValue("BOLNumber");
	    for(int i = 0; i < excel.size(); i++) {
	    	header = spreadsheet.createRow(i+1);
	    	header.createCell(0).setCellValue(excel.get(i).getEquipmentNumber());
		    header.createCell(1).setCellValue(excel.get(i).getVessel());
		    header.createCell(2).setCellValue(excel.get(i).getVoyage());
		    header.createCell(3).setCellValue(excel.get(i).getWorkOrderNumber());
		    header.createCell(4).setCellValue(excel.get(i).getShipmentReferenceNumber());
		    header.createCell(5).setCellValue(excel.get(i).getBillOfLadingNumber());
	    }
	    FileOutputStream out = new FileOutputStream(new File("C:\\Users\\pvanausdeln\\Dropbox (Blume Global)\\Documents\\UiPath\\PortTerminalScraping\\"+dir+"\\Test.xlsx"));
	    workbook.write(out);
	    out.close();
	    workbook.close();
	    
		return;
	}
	
}