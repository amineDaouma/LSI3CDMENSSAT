package fr.enssat.dao;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.beans.OrgUnit;

public class CdmDAO2Impl implements CdmDAO2{

	@Override
	public List<CDM> findAll() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		return session.createQuery("from cdm").list();
	}

	@Override
	public CDM findByID(String idCDM) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<CDM> cdms = findAll();
		for (CDM cdm : cdms) {
			if(cdm.getProgram().getProgramID().equals(idCDM)){
				return cdm;
			}
		}
		return null;
		
	}

	@Override
	public CDM updateCDM(String idCDM, CDM newCDM) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CDM cdm=findByID(idCDM);
		if(cdm!=null){
			newCDM.setHjid(cdm.getHjid());				
			session.saveOrUpdate(newCDM);				
			session.getTransaction().commit();			
			session.close();
			sessionFactory.close();
			return newCDM;			
		}
		return null;
	}

	@Override
	public CDM addCDM(CDM newCDM) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CDM cdm=findByID(newCDM.getProgram().getProgramID());
		if(cdm==null){
			session.save(newCDM);		
			session.getTransaction().commit();		
			session.close();
			sessionFactory.close();
			return newCDM;
		}else{
			return null;
		}
	}

	@Override
	public CDM addCDM(String newCDM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CDM supprimeCDM(String idCDM) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		CDM cdm=findByID(idCDM);
		if(cdm!=null){
			session.delete(cdm);		
			session.getTransaction().commit();		
			session.close();
			sessionFactory.close();
			return cdm;
		}else{
			return null;
		}
	}

}
