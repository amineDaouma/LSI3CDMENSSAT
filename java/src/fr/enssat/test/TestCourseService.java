package fr.enssat.test;	

import static org.junit.Assert.*;

import org.junit.Test;

import fr.enssat.beans.*;
import fr.enssat.services.*;


public class TestCourseService {

	@Test
	public void course() {

		
		CDMService2 serviceCDM = new CDMServiceImpl2();
		CourseService serviceCourse = new CourseServiceImpl();
		
		CDM cdm = Parseur.xmlToCDM();
		String id = cdm.getProgram().getId();
		serviceCDM.addCDM(cdm);
		
		
		
		Course maths = Parseur.xmlToCourse(1);
		String idMath = maths.getId();
		
		serviceCourse.addCourse(id, maths);
		assertNotNull("Recuperation Message", serviceCourse.findAll(id));
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
