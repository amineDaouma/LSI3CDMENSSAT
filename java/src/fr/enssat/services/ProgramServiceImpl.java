package fr.enssat.services;

import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;
import fr.enssat.dao.ProgramDAO;
import fr.enssat.dao.ProgramDAOImpl;

public class ProgramServiceImpl implements ProgramService
{
	
	ProgramDAO dao = new  ProgramDAOImpl();

	@Override
	public Program getProgram(String idCDM) 
	{
		return dao.getProgram(idCDM);
	}

	@Override
	public Program updateProgram(String idCDM, Program newProgram) 
	{
		return dao.updateProgram(idCDM, newProgram);
	}

	@Override
	public SubProgram getSubProgram(String idCDM, String subProgramID) 
	{
		// TODO Auto-generated method stub
		return dao.getSubProgram(idCDM, subProgramID);
	}

	@Override
	public SubProgram addSubProgram(String idCDM, SubProgram subProgram) 
	{
		// TODO Auto-generated method stub
		return dao.addSubProgram(idCDM, subProgram);
	}

	@Override
	public SubProgram updateSubProgram(String idCDM, String idSubProgram,
			SubProgram newSubProgram) 
	{
		// TODO Auto-generated method stub
		return dao.updateSubProgram(idCDM, idSubProgram, newSubProgram);
	}

	@Override
	public SubProgram deleteSubProgram(String idCDM, String idSubProgram) 
	{
		// TODO Auto-generated method stub
		return dao.deleteSubProgram(idCDM, idSubProgram);
	}

}
