package fr.enssat.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.BasicConfigurator;

import fr.enssat.beans.*;
import fr.enssat.services.*;

public class MockEtienne {
	

	private Course xmlToCourse() {
		try {

			File file = new File("WebContent/WEB-INF/xml/course.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Course course = (Course) jaxbUnmarshaller.unmarshal(file);
			return course;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Course getCourseById (List<Course> listeCours, String id) {
	
		Course courseFound = null;
		for (Course course : listeCours) {
			if (course.getId().equals(id)){
				courseFound = course;
			}
		}
		
		return courseFound;
	}

	@Test
	public void addCourse() {
		BasicConfigurator.configure();
		
		Course maths = xmlToCourse();
		CdmService service = new CdmServiceImpl();
		service.addCourse(maths);
	
		List<Course> listeCours = service.getAllCourses();
	
		Course coursRecuperer = getCourseById(listeCours, maths.getId());
		assertNotNull("Ajout cours ",coursRecuperer);
		
		service.deleteCourseById(maths.getId());
	}

	@Test
	public void deleteCourseById() {
		
		BasicConfigurator.configure();
		Course maths = xmlToCourse();

		CdmService service = new CdmServiceImpl();
		service.addCourse(maths);	
		
		List<Course> listeCours = service.getAllCourses();
		Course coursRecuperer = getCourseById(listeCours, maths.getId());
		assertNotNull("Ajout cours ",coursRecuperer);
		
		service.deleteCourseById(maths.getId());
		listeCours = service.getAllCourses();
		coursRecuperer = getCourseById(listeCours, maths.getId());
		assertNull("Cours non supprimé ",coursRecuperer);
	}

}
