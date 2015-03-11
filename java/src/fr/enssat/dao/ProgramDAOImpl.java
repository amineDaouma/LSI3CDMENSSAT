
package fr.enssat.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;

public class ProgramDAOImpl implements ProgramDAO 
{

	@Override
	public Program getProgram(String idCDM) 
	{	
		Session session = CdmDAOImpl.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Program> retour = (List<Program>) (session.createQuery("from Program").list());
		for(Program program : retour)
		{
			if (program.getProgramID().equals(idCDM))
			{
				return program;
			}
		}
		return null;
	}

	@Override
	public Program updateProgram(String idCDM, Program newProgram) {	
		Session session = CdmDAOImpl.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Program> retour = (List<Program>) (session.createQuery("from Program").list());
		for(Program program : retour)
		{
			if (program.getProgramID().equals(idCDM))
			{
				newProgram.setHjid(program.getHjid());
				session.merge(newProgram);
				session.getTransaction().commit();
				return newProgram;
			}
		}
		return null;
	}

	@Override
	public SubProgram getSubProgram(String idCDM, String subProgramID) {
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		for (CDM cdm : cdms)
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				List<SubProgram> subPrograms=cdm.getProgram().getSubProgram();
				for (SubProgram subProgram : subPrograms) {
					if(subProgram.getId().equals(subProgramID)){
						return subProgram;				
					} 
				}
				
			}
		}

		session.getTransaction().commit();
		return null;		

	}

	@Override
	public SubProgram addSubProgram(String idCDM, SubProgram subProgram) {
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		for (CDM cdm : cdms)
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				//debut traitement
				for(SubProgram subProgramCourant  : cdm.getProgram().getSubProgram())
				{
					if(subProgramCourant.getId().equals(subProgram.getId()))
					{
						session.getTransaction().commit();
						return null;
					}
				}
				cdm.getProgram().getSubProgram().add(subProgram);
				session.saveOrUpdate(cdm);
				session.getTransaction().commit();
				return subProgram;
				//fin traitement
			}
		}
		session.getTransaction().commit();
		return null;
	}

	@Override
	public SubProgram updateSubProgram(String idCDM, String idSubProgram,
			SubProgram newSubProgram) {
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
				List<SubProgram> listeSubPrograms = cdm.getProgram().getSubProgram();
				tailleListe = listeSubPrograms.size();
				for(i=0;i<tailleListe;i++)
				{
					if (listeSubPrograms.get(i).getId().equals(idSubProgram))
					{
						listeSubPrograms.set(i, newSubProgram);
						session.saveOrUpdate(cdm);
						session.getTransaction().commit();
						return newSubProgram;
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
	public SubProgram deleteSubProgram(String idCDM, String idSubProgram) {
		SessionFactory sessionFactory = CdmDAOImpl.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = (List<CDM>) (session.createQuery("from CDM").list());
		for (CDM cdm : cdms)
		{
			if(cdm.getProgram().getProgramID().equals(idCDM))
			{
				//debut traitement
				for(SubProgram subProgram : cdm.getProgram().getSubProgram())
				{
					if(subProgram.getId().equals(idSubProgram))
					{
						cdm.getProgram().getSubProgram().remove(subProgram);
						session.saveOrUpdate(cdm);
						session.getTransaction().commit();
						return subProgram;
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
