package fr.enssat.services;

import fr.enssat.beans.OrgUnit;
import fr.enssat.dao.OrgUnitDAO;
import fr.enssat.dao.OrgUnitDAOImpl;

public class OrgUnitServiceImpl implements OrgUnitService 
{
	
	OrgUnitDAO dao = new OrgUnitDAOImpl();

	@Override
	public OrgUnit getOrgUnit(String idCDM) 
	{
		
		return dao.getOrgUnit(idCDM);
	}

	@Override
	public OrgUnit updateOrgUnit(String idCDM, OrgUnit newOrgUnit) 
	{
		// TODO Auto-generated method stub
		return dao.updateOrgUnit(idCDM, newOrgUnit);
	}

}
