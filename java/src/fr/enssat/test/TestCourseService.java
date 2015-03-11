package fr.enssat.test;	

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import fr.enssat.beans.*;
import fr.enssat.services.*;


public class TestCourseService {
	
//	public List <Course> findAll(String idCDM);
//	public Course findByID(String idCDM, String IDCourse);
//	public Course updateCours (String idCDM, String IDCourse, Course newCourse);
//	public Course addCourse(String idCDM, Course newCourse);
//	public Course removeCourse(String IDCDM,String idCourse);
	

	
	@Test
	public void addCourse() {
		//BasicConfigurator.configure();
		
		CDMService2 serviceCDM = new CDMServiceImpl2();
		CourseService serviceCourse = new CourseServiceImpl();
		
		CDM cdm = Parseur.xmlToCDM();
		String id = cdm.getProgram().getId();
		serviceCDM.addCDM(cdm);
		
		
		
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
		
		
	}

}
