package fr.enssat.test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;

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
	
	public static CDM xmlToCDM2() {
		try {

			File file = new File("WebContent/WEB-INF/xml/cdm2.xml");
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
	
	public static Program xmlToProgram() {
		try {

			File file = new File("WebContent/WEB-INF/xml/program.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Program.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Program prog = (Program) jaxbUnmarshaller.unmarshal(file);
			return prog;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	

	public static SubProgram xmlToSubProgram2() {
		try {

			File file = new File("WebContent/WEB-INF/xml/subProgramUpdate.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(SubProgram.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			SubProgram subProg = (SubProgram) jaxbUnmarshaller.unmarshal(file);
			return subProg;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static SubProgram xmlToSubProgram() {
		try {

			File file = new File("WebContent/WEB-INF/xml/subProgram.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(SubProgram.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			SubProgram subProg = (SubProgram) jaxbUnmarshaller.unmarshal(file);
			return subProg;
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}
}
