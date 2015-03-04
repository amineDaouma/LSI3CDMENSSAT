package fr.enssat.services;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.dao.CdmDAO;
import fr.enssat.dao.CdmDAOImpl;

public class CdmServiceImpl implements CdmService {

	private CdmDAO dao = new CdmDAOImpl();
	
	public CdmServiceImpl() {
		super();
	}

	public List<CDM> findAll(){
		return dao.findAll();
	}
	
	public void uploadCDM(CDM cdm){
		dao.uploadCDM(cdm);
	}
	
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return dao.getAllCourses();
	}

	@Override
	public void addCourse(Course c) {
		dao.addCourse(c);
		
	}

	@Override
	public void deleteCourseById(String ident) {

		dao.deleteCourseById(ident);
	}

	@Override
	public void updateLevelByCourseId(String ident,String newValue) {
		dao.updateLevelByCourseId(ident,newValue);
		
	}

	@Override
	public void updateTeachingTermOfCourseById(String ident, String newValue) {
		dao.updateTeachingTermOfCourseById(ident, newValue);
	}

	@Override
	public Program getProgram() {
		// TODO Auto-generated method stub
		return dao.getProgram();
	}

	@Override
	public OrgUnit getOrgUnit() {
		
		return dao.getOrgUnit();
	}

}
