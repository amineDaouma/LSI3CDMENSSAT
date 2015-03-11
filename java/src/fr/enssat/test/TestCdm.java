package fr.enssat.test;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

import fr.enssat.beans.CDM;
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;


public class TestCdm {
	
		
	@Test
	public void addCdm() {
		
		CDM cdm = Parseur.xmlToCDM();
		CDMService2 service = new CDMServiceImpl2();
		service.addCDM(cdm);
	
		List<CDM> listeCDM = service.findAll();
		System.out.println(listeCDM.toString());
	
		CDM cdmARecuperer = service.findByID(cdm.getProgram().getProgramID());
		assertNotNull("Ajout cdm ",cdmARecuperer);
		System.out.println("le cdm recherché : "+cdmARecuperer);
		
		//service.supprimeCDM(cdm.getProgram().getProgramID());
	}
	
	@Test
	public void getCDMById(){
		CDM cdmTest = Parseur.xmlToCDM();
		CDMService2 service = new CDMServiceImpl2();
		CDM cdmFound = service.findByID(cdmTest.getProgram().getId());
		assertNotNull("cdm is found", cdmFound);

	}

	/*@Test
	public void deleteCdmById() {
		
		CDM cdm = xmlToCDM();

		CDMService2 service = new CDMServiceImpl2();
		service.addCDM(cdm);	
		
		//List<CDM> listeCdm = service.findAll();
		CDM cdmRecuperer = service.findCDMByID(cdm.getProgram().getProgramID());
		assertNotNull("Ajout cdm ",cdmRecuperer);
		
		service.supprimeCDM(cdm.getProgram().getProgramID());
		//List<CDM> listeCdm = service.findAll();
		cdmRecuperer = service.findCDMByID(cdm.getProgram().getProgramID());
		assertNull("cdm non supprimé ",cdmRecuperer);
	}*/
	
	@Test
	public void update(){
		
		
		CDM cdm = Parseur.xmlToCDM();
		CDM cdm1 = Parseur.xmlToCDM2();


		CDMService2 service = new CDMServiceImpl2();
		service.addCDM(cdm);
		
		CDM cdmInserted = service.updateCDM(cdm.getProgram().getId(), cdm1);
		assertNotNull("non vide ce cdm", cdmInserted);
		//if(cdmUpdated == null) System.out.println("cdm vide");
		//assertNotNull("cdm modifié non nul",cdmUpdated);
		//CDM cdmGot = (CDM) service.findCDMByID(cdm1.getProgram().getId());
		//assertNotNull(cdmGot);
		//assertTrue(cdmGot.equals(cdm1));
		
		}

}
