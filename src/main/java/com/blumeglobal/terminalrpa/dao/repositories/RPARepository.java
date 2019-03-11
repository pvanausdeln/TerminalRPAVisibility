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
	
	@Query(value = "select\r\n" + 
			"ew.EQUIPMENTNUMBER ,\r\n" + 
			"w.VESSEL,\r\n" + 
			"w.VOYAGE,\r\n" + 
			"w.workordernumber,\r\n" + 
			"w.SHIPMENTREFERENCENUMBER,\r\n" + 
			"w.BILLOFLADINGNUMBER\r\n" + 
			"from\r\n" + 
			"dm.workorder w,\r\n" + 
			"dm.equipmentonworkorder ew,\r\n" + 
			"dm.stop s\r\n" + 
			"where ew.workorderid = w.workorderid\r\n" + 
			"and s.workorderid = w.workorderid\r\n" + 
			"AND ew.EQUIPMENTNUMBER IS NOT null\r\n" + 
			"--and w.statusid in (2,3)\r\n" + 
			"and (category like 'Import%' or originatororderreference = 'Import-Ocean')\r\n" + 
			"and s.stopnumber = 1\r\n" + 
			"and s.name like '%BEN E%'\r\n" + 
			"and trunc(workorderdate) >= trunc(sysdate-45)\r\n" + 
			"order by w.lastfreeday ASC;", nativeQuery=true)
	List<IRPAQuery> EverportOAKSearch();
	
	@Query(value = "", nativeQuery = true)
	List<IRPAQuery> EverportTACSearch();
	
}