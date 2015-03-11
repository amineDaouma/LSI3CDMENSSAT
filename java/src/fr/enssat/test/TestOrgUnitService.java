package fr.enssat.test;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.enssat.beans.CDM;
import fr.enssat.beans.OrgUnit;
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;
import fr.enssat.services.OrgUnitService;
import fr.enssat.services.OrgUnitServiceImpl;

public class TestOrgUnitService {
	
	@Test
	public void updateOrgUnit() {

		
		CDMService2 serviceCDM = new CDMServiceImpl2();
		OrgUnitService serviceOrgunit = new OrgUnitServiceImpl();
		
		CDM cdm = Parseur.xmlToCDM();
		String id = cdm.getProgram().getId();
		
		OrgUnit orgUnit = Parseur.xmlToOrgUnit(1);
	
		serviceCDM.addCDM(cdm);
		OrgUnit orgUnitRecupere = serviceOrgunit.getOrgUnit(id);
		assertNotNull("get OrgUnit ", orgUnitRecupere);
		
		orgUnit = Parseur.xmlToOrgUnit(2);
		serviceOrgunit.updateOrgUnit(id, orgUnit);
		
		orgUnitRecupere = serviceOrgunit.getOrgUnit(id);
		assertNotNull("get OrgUnit update", orgUnitRecupere);
		assertTrue("uptdate orgUnit", orgUnit.equals(orgUnitRecupere));
		
		
		serviceCDM.supprimeCDM(id);
		
		
		
		
	}




}
