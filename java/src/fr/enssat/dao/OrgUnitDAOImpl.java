package fr.enssat.dao;

import fr.enssat.beans.*;
import AnnotationConfiguration;
import CDM;
import Course;
import List;
import Session;
import SessionFactory;

public class OrgUnitDAOImpl implements OrgUnitDAO{

	@Override
	public OrgUnit getOrgUnit(String idCDM) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<CDM> cdms = session.createQuery("from cdm").list();
		for (CDM cdm : cdms) {
			if(cdm.getProgram().getProgramID().equals(idCDM)){
				OrgUnit orgUnit=cdm.getOrgUnit();
				session.close();
				sessionFactory.close();
				return orgUnit;		
			}
		}
		session.close();
		sessionFactory.close();
		return null;
	}

	@Override
	public boolean updateOrgUnit(String idCDM, OrgUnit newOrgUnit) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		OrgUnit orgUnit=getOrgUnit(idCDM);
		if(orgUnit!=null){
			newCourse.setHjid(course.getHjid());			
			session.saveOrUpdate(newCourse);				
			session.getTransaction().commit();			
			session.close();
			sessionFactory.close();
			return newCourse;			
		}
		return false;
	}

}
