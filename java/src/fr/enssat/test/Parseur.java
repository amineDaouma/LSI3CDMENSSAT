package fr.enssat.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;

public class Parseur {

	public static Course xmlToCourse(int i) {
		try {

			File file = new File("WebContent/WEB-INF/xml/course"+i+".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Course course = (Course) jaxbUnmarshaller.unmarshal(file);
			return course;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public static CDM xmlToCDM() {
		try {

			File file = new File("WebContent/WEB-INF/xml/cdm.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(CDM.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			CDM  cdm = (CDM) jaxbUnmarshaller.unmarshal(file);
			return cdm;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static OrgUnit xmlToOrgUnit(int i) {
		try {

			File file = new File("WebContent/WEB-INF/xml/orgunit"+i+".xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(OrgUnit.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			OrgUnit orgUnit = (OrgUnit) jaxbUnmarshaller.unmarshal(file);
			return orgUnit;

		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
