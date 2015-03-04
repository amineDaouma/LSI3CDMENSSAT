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
import fr.enssat.services.CourseService;
import fr.enssat.services.CourseServiceImpl;
import fr.enssat.services.OrgUnitService;
import fr.enssat.services.OrgUnitServiceImpl;

public class Fonctionnalite_CourseService {
	
//	public List <Course> findAll(String idCDM);
//	public Course findByID(String idCDM, String IDCourse);
//	public Course updateCours (String idCDM, String IDCourse, Course newCourse);
//	public Course addCourse(String idCDM, Course newCourse);
//	public Course removeCourse(String IDCDM,String idCourse);
	

	
	@Test
	public void addCourse() {
		BasicConfigurator.configure();
		
		CDMService2 serviceCDM = new CDMServiceImpl2();
		CourseService serviceCourse = new CourseServiceImpl();
		
		CDM cdm = Parseur.xmlToCDM();
		String id = cdm.getProgram().getId();
		
		Course maths = Parseur.xmlToCourse(1);
		String idMath = maths.getId();
		
		serviceCourse.addCourse(id, maths);
		Course mathsRecupere = serviceCourse.findByID(id, idMath);
		assertNotNull("Get cours",mathsRecupere);
		assertTrue("Ajout d'un programme ", maths.equals(mathsRecupere));

		maths = Parseur.xmlToCourse(2);
		serviceCourse.updateCours(id, idMath, maths);
		mathsRecupere = serviceCourse.findByID(id, idMath);
		assertNotNull("Ajout cours ", mathsRecupere);
		
		serviceCourse.removeCourse(id, idMath);
		mathsRecupere = serviceCourse.findByID(id, idMath);
		assertNull("Suppression cours",mathsRecupere);
		
		serviceCDM.supprimeCDM(id);
		
	}

}
