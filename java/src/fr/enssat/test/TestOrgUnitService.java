package fr.enssat.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;
import fr.enssat.services.CdmService;
import fr.enssat.services.CdmServiceImpl;
import fr.enssat.services.OrgUnitService;
import fr.enssat.services.OrgUnitServiceImpl;

public class TestOrgUnitService {
	
	
	

	@Test
	public void updateOrgUnit() {
		BasicConfigurator.configure();
		
		CDMService2 serviceCDM = new CDMServiceImpl2();
		OrgUnitService serviceOrgunit = new OrgUnitServiceImpl();
		
		CDM cdm = Parseur.xmlToCDM();
		String id = cdm.getProgram().getId();
		
		OrgUnit orgUnit = Parseur.xmlToOrgUnit(1);
	
		serviceCDM.addCDM(cdm);
		OrgUnit orgUnitRecupere = serviceOrgunit.getOrgUnit(id);
		assertTrue("get OrgUnit ", orgUnit.equals(orgUnitRecupere));
		
		orgUnit = Parseur.xmlToOrgUnit(2);
		serviceOrgunit.updateOrgUnit(id, orgUnit);
		
		orgUnitRecupere = serviceOrgunit.getOrgUnit(id);
		assertTrue("uptdate orgUnit", orgUnit.equals(orgUnitRecupere));
		
		
		serviceCDM.supprimeCDM(id);
		
		
		
		
	}




}
