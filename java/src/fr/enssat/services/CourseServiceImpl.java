package fr.enssat.services;

import java.util.List;

import fr.enssat.beans.Course;
import fr.enssat.beans.CourseList;
import fr.enssat.dao.CourseDAO;
import fr.enssat.dao.CourseDAOImpl;

public class CourseServiceImpl implements CourseService 
{
	private CourseDAO dao = new CourseDAOImpl()   ;
	@Override
	public CourseList findAll(String idCDM) 
	{
		// TODO Auto-generated method stub
		return dao.findAll(idCDM);
	}

	@Override
	public Course findByID(String idCDM, String IDCourse) 
	{
		// TODO Auto-generated method stub
		return dao.findByID(idCDM, IDCourse);
	}

	@Override
	public Course updateCours(String idCDM, String IDCourse, Course newCourse) 
	{
		// TODO Auto-generated method stub
		return dao.updateCours(idCDM, IDCourse, newCourse);
	}

	@Override
	public Course addCourse(String idCDM, Course newCourse) 
	{
		// TODO Auto-generated method stub
		return dao.addCourse(idCDM, newCourse);
	}

	@Override
	public Course removeCourse(String IDCDM, String idCourse) 
	{
		// TODO Auto-generated method stub
		return dao.removeCourse(IDCDM, idCourse);
	}

}
