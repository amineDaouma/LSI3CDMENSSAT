package fr.enssat.dao;

import java.util.List;

import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;


public interface CdmDAO {

	public void addCourse(Course c);
	public List<Course> getAllCourses();
	public void deleteCourseById(String ident);
	public void updateLevelByCourseId(String ident,String newValue);
	public void updateTeachingTermOfCourseById (String ident,String newValue);
	public Program getProgram();
	public OrgUnit getOrgUnit();
	
}
