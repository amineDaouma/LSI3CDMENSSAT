package fr.enssat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import fr.enssat.beans.*;
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
	public OrgUnit updateOrgUnit(String idCDM, OrgUnit newOrgUnit) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		OrgUnit orgUnit=getOrgUnit(idCDM);
		if(orgUnit!=null){
			newOrgUnit.setHjid(orgUnit.getHjid());			
			session.saveOrUpdate(newOrgUnit);				
			session.getTransaction().commit();			
			session.close();
			sessionFactory.close();
			return newOrgUnit;			
		}
		return null;
	}

}
