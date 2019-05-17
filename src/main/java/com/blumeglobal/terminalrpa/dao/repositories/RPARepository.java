package com.blumeglobal.terminalrpa.dao.repositories;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blumeglobal.terminalrpa.model.IRPAQuery;
import com.blumeglobal.terminalrpa.model.RPAEvent;
import com.rez1.common.annotations.REZ1Logger;
import com.rez1.common.annotations.REZ1PerformanceLogger;
/**
 * The ShipmentSchedulesRepository is used to maintain ShipmentSchedule entity operation
 *
 */
@Repository
@REZ1Logger
@REZ1PerformanceLogger
public interface RPARepository extends CrudRepository<RPAEvent, Long>, JpaSpecificationExecutor<RPAEvent>{
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.name like '%APM%' \n" + 
			"AND w.originatorname LIKE '%Los Angeles%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-5)", nativeQuery = true)
	List<IRPAQuery> APMLASearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%BAYPORT%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-10) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE)", nativeQuery = true)
	List<IRPAQuery> BayportSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%BARBOURS%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-30) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE)", nativeQuery = true)
	List<IRPAQuery> BarboursSearch();
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER , \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from  \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.state = 'CA' \n" + 
			"and s.name like '%EVERPORT%' \n" + 
			"and w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT NULL \n" + 
			"AND w.SHIPMENTREFERENCENUMBER IS NOT NULL \n" +
			"AND w.ORIGINATORNAME LIKE '%Los Angeles%' \n" +
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" +
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> EverportLASearch();
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT null \n" + 
			"-- and w.statusid in (2,3) \n" +
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.name like '%BEN E%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> EverportOAKSearch();
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.name like '%PIERCE%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> EverportTACSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND S.STATE like '%WA%' \n" + 
			"AND s.NAME LIKE '%HUSKY TERMINAL%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-5)", nativeQuery = true)
	List<IRPAQuery> HuskyTACSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER, \n" + 
			"s.name \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%ITS%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-7) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE-1)", nativeQuery = true)
	List<IRPAQuery> ITSLBSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND S.STATE like '%CA%' \n" + 
			"AND s.NAME LIKE '%LONG BEACH CONTAINER%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> LBCTSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%MAHER%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-10) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE)", nativeQuery = true)
	List<IRPAQuery> MaherSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%SOUTH FLORIDA%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-30) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE)", nativeQuery = true)
	List<IRPAQuery> MiamiSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name like '%NORTH CHAR%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-15) AND trunc(WORKORDERDATE) < trunc(sysdate-2)", nativeQuery = true)
	List<IRPAQuery> NCTSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%PORT NEWARK%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-7) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE)", nativeQuery = true)
	List<IRPAQuery> NewarkSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.name like '%PCT%' \n" + 
			"AND w.ORIGINATORNAME LIKE '%Los Angeles%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-45) \n", nativeQuery = true)
	List<IRPAQuery> PacificLBSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%PACKER%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-30) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE-1) \n", nativeQuery = true)
	List<IRPAQuery> PackerSearch();
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER , \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from  \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.state = 'WA' \n" + 
			"and s.name like '%18%' \n" + 
			"and w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT NULL \n" + 
			"AND w.SHIPMENTREFERENCENUMBER IS NOT NULL \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" +
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> SeattleT18Search();
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER , \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from  \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.state = 'WA' \n" + 
			"and s.name like '% 30%' \n" + 
			"and w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT NULL \n" + 
			"AND w.SHIPMENTREFERENCENUMBER IS NOT NULL \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" +
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> SeattleT30Search();
	
	@Query(value = "select \n" + 
			"ew.EQUIPMENTNUMBER , \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from  \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.state = 'WA' \n" + 
			"and s.name like '%46%' \n" + 
			"and w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT NULL \n" + 
			"AND w.SHIPMENTREFERENCENUMBER IS NOT NULL \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" +
			"and trunc(workorderdate) >= trunc(sysdate-45)", nativeQuery = true)
	List<IRPAQuery> SeattleT46Search();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name LIKE '%TACOMA CONTAINER TERMINAL%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-30) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE-1)", nativeQuery = true)
	List<IRPAQuery> TCTSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND s.name LIKE '%TRAPAC JA%' \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-5) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE-1)", nativeQuery = true)
	List<IRPAQuery> TPJAXSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"and s.name like '%TRAPAC LOS ANGELES%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-5)", nativeQuery = true)
	List<IRPAQuery> TPLASearch();
		
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND s.name LIKE '%TRAPAC OAKLAND%' \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-5)", nativeQuery = true)
	List<IRPAQuery> TPOAKSearch();
	
	@Query(value = "SELECT \r\n" + 
			"ew.EQUIPMENTNUMBER,\r\n" + 
			"w.VESSEL,\r\n" + 
			"w.VOYAGE,\r\n" + 
			"w.workordernumber,\r\n" + 
			"w.SHIPMENTREFERENCENUMBER,\r\n" + 
			"w.BILLOFLADINGNUMBER,\r\n" + 
			"s.name\r\n" + 
			"from\r\n" + 
			"dm.workorder w,\r\n" + 
			"dm.equipmentonworkorder ew,\r\n" + 
			"dm.stop s\r\n" + 
			"where ew.workorderid = w.workorderid\r\n" + 
			"and s.workorderid = w.workorderid\r\n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL\r\n" + 
			"AND w.vessel IS NOT NULL\r\n" + 
			"AND w.voyage IS NOT null\r\n" + 
			"and w.statusid in (2,3)\r\n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean')\r\n" + 
			"and s.stopnumber = 1\r\n" + 
			"AND w.vessel IS NOT NULL\r\n" + 
			"AND w.VOYAGE IS NOT null\r\n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL\r\n" + 
			"AND s.name LIKE '%TOTAL TERMINAL%'\r\n" + 
			"and trunc(workorderdate) >= trunc(sysdate-30) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE-1)", nativeQuery = true)
	List<IRPAQuery> TTILBSearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER, \n" + 
			"s.name, \n" + 
			"s.state, \n" + 
			"w.WORKORDERDATE, \n" + 
			"w.LASTFREEDAY, \n" + 
			"sysdate, \n" + 
			"trunc(sysdate) \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name like '%WBCT%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-15) AND TRUNC(WORKORDERDATE) < trunc(SYSDATE)", nativeQuery = true)
	List<IRPAQuery> WBCTLASearch();
	
	@Query(value = "SELECT  \n" + 
			"ew.EQUIPMENTNUMBER, \n" + 
			"w.VESSEL, \n" + 
			"w.VOYAGE, \n" + 
			"w.workordernumber, \n" + 
			"w.SHIPMENTREFERENCENUMBER, \n" + 
			"w.BILLOFLADINGNUMBER \n" + 
			"from \n" + 
			"dm.workorder w, \n" + 
			"dm.equipmentonworkorder ew, \n" + 
			"dm.stop s \n" + 
			"where ew.workorderid = w.workorderid \n" + 
			"and s.workorderid = w.workorderid \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.voyage IS NOT null \n" + 
			"and w.statusid in (2,3) \n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
			"and s.stopnumber = 1 \n" + 
			"AND w.vessel IS NOT NULL \n" + 
			"AND w.VOYAGE IS NOT null \n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
			"AND s.name like '%WANDO WELCH%' \n" + 
			"and trunc(workorderdate) >= trunc(sysdate-30) \n" + 
			"AND w.LASTFREEDAY < trunc(SYSDATE-1) \n", nativeQuery = true)
	List<IRPAQuery> WWTSearch();
	
//	@Query(value = "SELECT  \n" + 
//			"ew.EQUIPMENTNUMBER, \n" + 
//			"w.VESSEL, \n" + 
//			"w.VOYAGE, \n" + 
//			"w.workordernumber, \n" + 
//			"w.SHIPMENTREFERENCENUMBER, \n" + 
//			"w.BILLOFLADINGNUMBER, \n" + 
//			"s.name, \n" + 
//			"w.originatorname \n" + 
//			"from \n" + 
//			"dm.workorder w, \n" + 
//			"dm.equipmentonworkorder ew, \n" + 
//			"dm.stop s \n" + 
//			"where ew.workorderid = w.workorderid \n" + 
//			"and s.workorderid = w.workorderid \n" + 
//			"AND ew.EQUIPMENTNUMBER IS NOT NULL \n" + 
//			"AND w.vessel IS NOT NULL \n" + 
//			"AND w.voyage IS NOT null \n" + 
//			"and w.statusid in (2,3) \n" + 
//			"and (category like 'Import%' or originatororderreference = 'Import-Ocean') \n" + 
//			"and s.stopnumber = 1 \n" + 
//			"and s.name like '%YANG MING%' \n" + 
//			"and w.originatorname like '%Los Angeles%' \n" +
//			"and trunc(workorderdate) >= trunc(sysdate-730)", nativeQuery = true)
//	List<IRPAQuery> YMLASearch();
	
}