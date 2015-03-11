package fr.enssat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import fr.enssat.beans.*;
public class OrgUnitDAOImpl implements OrgUnitDAO{

	@Override
	public OrgUnit getOrgUnit(String idCDM) {
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		List<CDM> cdms = session.createQuery("from cdm").list();
//		for (CDM cdm : cdms) {
//			if(cdm.getProgram().getProgramID().equals(idCDM)){
//				OrgUnit orgUnit=cdm.getOrgUnit();
//				session.close();
//				sessionFactory.close();
//				return orgUnit;		
//			}
//		}
//		session.close();
//		sessionFactory.close();
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
				
				return cdm.getOrgUnit();
				
				//fin traitement
				
				//pour l'instant, pas de commit car pas de meilleure solution
			}
		}
		session.getTransaction().commit();
		return null;
	}

	@Override
	public OrgUnit updateOrgUnit(String idCDM, OrgUnit newOrgUnit) {
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		OrgUnit orgUnit=getOrgUnit(idCDM);
//		if(orgUnit!=null){
//			newOrgUnit.setHjid(orgUnit.getHjid());			
//			session.saveOrUpdate(newOrgUnit);				
//			session.getTransaction().commit();			
//			session.close();
//			sessionFactory.close();
//			return newOrgUnit;			
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
				cdm.setOrgUnit(newOrgUnit);
				session.saveOrUpdate(cdm);
				session.getTransaction().commit();
				return newOrgUnit;
				
				//fin traitement
				
				//pour l'instant, pas de commit car pas de meilleure solution
			}
		}
		session.getTransaction().commit();
		return null;
	}

}
