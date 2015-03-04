package fr.enssat.services;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.dao.CdmDAO2;
import fr.enssat.dao.CdmDAO2Impl;

public class CDMServiceImpl2 implements CDMService2
{
	private CdmDAO2 dao = new CdmDAO2Impl() ;
	@Override
	public List<CDM> findAll() 
	{
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public CDM findByID(String idCDM) 
	{
		// TODO Auto-generated method stub
		return dao.findByID(idCDM);
	}

	@Override
	public CDM updateCDM(String idCDM, CDM newCDM) 
	{
		// TODO Auto-generated method stub
		return dao.updateCDM(idCDM, newCDM);
	}

	@Override
	public CDM addCDM(CDM newCDM) 
	{
		// TODO Auto-generated method stub
		return dao.addCDM(newCDM);
		
	}

	@Override
	public CDM supprimeCDM(String idCDM) 
	{
		// TODO Auto-generated method stub
		return dao.supprimeCDM(idCDM);
	}

	@Override
	public CDM addCDM(String newCDM) 
	{
		// TODO Auto-generated method stub
		return dao.addCDM(newCDM);
	}
	
}
