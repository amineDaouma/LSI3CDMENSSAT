package fr.enssat.dao;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;

public class ProgramDAOImpl implements ProgramDAO {

	@Override
	public Program getProgram(String idCDM) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Program updateProgram(String idCDM, Program newProgram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubProgram getSubProgram(String idCDM, String subProgramID) {
		Program program=getProgram(idCDM);
		List<SubProgram> subPrograms=program.getSubProgram();
		for (SubProgram subProgram : subPrograms) {
			if(subProgram.getId().equals(subProgramID)){
				return subProgram;				
			}
		}		
	}

	@Override
	public SubProgram addSubProgram(String idCDM, SubProgram subProgram) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Program program=getProgram(idCDM);
		
		if(program!=null){
			session.save(subProgram);		
			session.getTransaction().commit();		
			session.close();
			sessionFactory.close();
			return subProgram;
		}
		return null;
	}

	@Override
	public SubProgram updateSubProgram(String idCDM, String idSubProgram,
			SubProgram newSubProgram) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Program program=getProgram(idCDM);
		List<SubProgram> subPrograms=program.getSubProgram();
		for (SubProgram subProgram : subPrograms) {
			if(subProgram.getId().equals(idSubProgram)){
				newSubProgram.setHjid(subProgram.getHjid());			
				session.saveOrUpdate(newSubProgram);				
				session.getTransaction().commit();			
				session.close();
				sessionFactory.close();
				return newSubProgram;
			}
		}
		return null;
	}

	@Override
	public SubProgram deleteSubProgram(String idCDM, String idSubProgram) {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Program program=getProgram(idCDM);
		List<SubProgram> subPrograms=program.getSubProgram();
		for (SubProgram subProgram : subPrograms) {
			if(subProgram.getId().equals(idSubProgram)){		
				session.delete(subProgram);				
				session.getTransaction().commit();			
				session.close();
				sessionFactory.close();
				return subProgram;
			}
		}
		return null;
	}

}
