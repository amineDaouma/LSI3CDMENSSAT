package fr.enssat.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.CourseList;

public class CourseDAOImpl implements CourseDAO{

	@Override
	public CourseList findAll(String idCDM) 
	{
		
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		
		for (CDM cdm : cdms) 
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				
				//debut traitement
				
				List<Course> retour = new ArrayList<Course>();
				for(Course c:cdm.getCourse())
				{
					
					retour.add(c);
				}
				
				CourseList liste =  new CourseList();
				liste.setListe(retour);
				return liste;
				
				//fin traitement
				
				//pour l'instant, pas de commit car pas de meilleure solution
			}
		}
				
		return null;
	}


	@Override
	public Course findByID(String idCDM, String IDCourse) {
//		SessionFactory sessionFactory = CdmDAO2Impl.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		List<CDM> cdms = session.createQuery("from cdm").list();
//		for (CDM cdm : cdms) {
//			if(cdm.getProgram().getProgramID().equals(idCDM)){
//				List<Course> courses=cdm.getCourse();
//				for (Course course : courses) {
//					if(course.getId().equals(IDCourse)){
//						return course;
//					}
//				}				
//			}
//		}
//		return null;
		
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list()); //on refait la fonctionnalite findAllCDM pour eviter d'ouvrir plusieurs sessions
		
		for (CDM cdm : cdms) 
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				
				//debut traitement
				
				for(Course course : cdm.getCourse())
				{
					if(course.getId().equals(IDCourse))
					{
						return (Course) course;
					}
				}
				
				//fin traitement
				
				//pour l'instant, pas de commit car pas de meilleure solution
			}
		}
				
		return null;
		
		
	}

	@Override
	public Course updateCours(String idCDM, String IDCourse, Course newCourse) 
	{
//		SessionFactory sessionFactory = CdmDAO2Impl.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Course course=findByID(idCDM,IDCourse);
//		if(course!=null){
//			newCourse.setHjid(course.getHjid());			
//			session.saveOrUpdate(newCourse);				
//			session.getTransaction().commit();			
//			session.close();
//			sessionFactory.close();
//			return newCourse;			
//		}
//		return null;
		int tailleListe;
		int i = 0;
		
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		
		for (CDM cdm : cdms) 
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				//debut traitement
				
				List<Course> listeCours = cdm.getCourse();
				tailleListe = listeCours.size();
				for(i=0;i<tailleListe;i++)
				{
					if (listeCours.get(i).getId().equals(IDCourse))
					{
						listeCours.set(i, newCourse);
						session.saveOrUpdate(cdm);
						session.getTransaction().commit();
						return newCourse;
					}
				}
				
				
				//fin traitement
				
				//pour l'instant, pas de commit car pas de meilleure solution
			}
		}
		session.getTransaction().commit();		
		return null;
	}

	@Override
	public Course addCourse(String idCDM, Course newCourse) {
//		SessionFactory sessionFactory = CdmDAO2Impl.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Course course=findByID(idCDM,newCourse.getId());
//		if(course==null){
//			session.save(newCourse);		
//			session.getTransaction().commit();		
//			session.close();
//			sessionFactory.close();
//			return newCourse;
//		}
//		return null;
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		
		for (CDM cdm : cdms) 
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				
				//debut traitement
				
				for(Course course : cdm.getCourse())
				{
					if(course.getId().equals(newCourse.getId()))
					{
						session.getTransaction().commit();
						return null;
					}
				}
				
				cdm.getCourse().add(newCourse);
				session.saveOrUpdate(cdm);
				session.getTransaction().commit();
				return newCourse;
				
				
				//fin traitement
			}
		}
		session.getTransaction().commit();
		return null;
		
	}

	@Override
	public Course removeCourse(String idCDM, String idCourse) {
//		SessionFactory sessionFactory = CdmDAO2Impl.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Course course=findByID(idCDM,idCourse);
//		if(course!=null){
//			session.delete(course);		
//			session.getTransaction().commit();		
//			session.close();
//			sessionFactory.close();
//			return course;
//		}
//		return null;
		
		
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		
		for (CDM cdm : cdms) 
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				
				//debut traitement
				
				for(Course course : cdm.getCourse())
				{
					if(course.getId().equals(idCourse))
					{
						cdm.getCourse().remove(course);
						
						session.saveOrUpdate(cdm);
						session.getTransaction().commit();
						return course;
					}
				}
				
				//fin traitement
				
				//pour l'instant, pas de commit car pas de meilleure solution
			}
		}
		session.getTransaction().commit();		
		return null;
	}

}
