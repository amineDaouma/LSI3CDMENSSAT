package fr.enssat.dao;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;

public class CourseDAOImpl implements CourseDAO{

	@Override
	public List<Course> findAll(String idCDM) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
				
		return session.createQuery("from Course").list();
	}

	@Override
	public Course findByID(String idCDM, String IDCourse) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<CDM> cdms = session.createQuery("from cdm").list();
		for (CDM cdm : cdms) {
			if(cdm.getProgram().getProgramID().equals(idCDM)){
				List<Course> courses=cdm.getCourse();
				for (Course course : courses) {
					if(course.getId().equals(IDCourse)){
						return course;
					}
				}				
			}
		}
		return null;
	}

	@Override
	public Course updateCours(String idCDM, String IDCourse, Course newCourse) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Course course=findByID(idCDM,IDCourse);
		if(course!=null){
			newCourse.setHjid(course.getHjid());			
			session.saveOrUpdate(newCourse);				
			session.getTransaction().commit();			
			session.close();
			sessionFactory.close();
			return newCourse;			
		}
		return null;
	}

	@Override
	public Course addCourse(String idCDM, Course newCourse) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Course course=findByID(idCDM,newCourse.getId());
		if(course==null){
			session.save(newCourse);		
			session.getTransaction().commit();		
			session.close();
			sessionFactory.close();
			return newCourse;
		}
		return null;
		
	}

	@Override
	public Course removeCourse(String IDCDM, String idCourse) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Course course=findByID(idCDM,idCourse);
		if(course!=null){
			session.delete(course);		
			session.getTransaction().commit();		
			session.close();
			sessionFactory.close();
			return course;
		}
		return null;
	}

}
