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
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;


public class TestCdm {
	
	private CDM xmlToCDM() {
		try {

			File file = new File("WebContent/WEB-INF/xml/cdm.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			CDM cdm = (CDM) jaxbUnmarshaller.unmarshal(file);
			return cdm;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private CDM xmlToCDM1() {
		try {

			File file = new File("WebContent/WEB-INF/xml/cdm2.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			CDM cdm = (CDM) jaxbUnmarshaller.unmarshal(file);
			return cdm;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	/*private Course getCdmById (List<Course> listeCours, String id) {
	
		Course courseFound = null;
		for (Course course : listeCours) {
			if (course.getId().equals(id)){
				courseFound = course;
			}
		}
		
		return courseFound;
	}*/

	@Test
	public void addCdm() {
		//BasicConfigurator.configure();
		
		CDM cdm = xmlToCDM();
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
		//BasicConfigurator.configure();
		CDM cdmTest = xmlToCDM();
		CDMService2 service = new CDMServiceImpl2();
		CDM cdmFound = service.findByID(cdmTest.getProgram().getId());
		assertNotNull("cdm is found", cdmFound);

	}

	/*@Test
	public void deleteCdmById() {
		
		//BasicConfigurator.configure();
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
		
		//BasicConfigurator.configure();
		
		CDM cdm = xmlToCDM();
		CDM cdm1 = xmlToCDM1();


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
