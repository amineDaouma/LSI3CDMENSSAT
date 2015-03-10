package fr.enssat.dao;

import java.util.List;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;

public class ProgramDAOImpl implements ProgramDAO 
{

	@Override
	public Program getProgram(String idCDM) 
	{
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		List<Program> programList = session.createQuery("from program").list();
//		for (Program program : programList) {
//			if(program.getProgramID().equals(idCDM)){
//						return program;
//			}
//		}
//		return null;
		
		Session session = CdmDAO2Impl.getSessionFactory().getCurrentSession();
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
//		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		
//		Program oldProgramm=getProgram(idCDM);
//		if(oldProgramm!=null){
//			newProgram.setHjid(oldProgramm.getHjid());			
//			session.saveOrUpdate(newProgram);				
//			session.getTransaction().commit();			
//			session.close();
//			sessionFactory.close();
//			return newProgram;			
//		}
//		return null;
		
		Session session = CdmDAO2Impl.getSessionFactory().getCurrentSession();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubProgram addSubProgram(String idCDM, SubProgram subProgram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program updateSubProgram(String idCDM, String idSubProgram,
			SubProgram newSubProgram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubProgram deleteSubProgram(String idCDM, String idSubProgram) {
		// TODO Auto-generated method stub
		return null;
	}

}
