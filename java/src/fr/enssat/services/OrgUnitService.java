package fr.enssat.services;

import fr.enssat.beans.OrgUnit;

public interface OrgUnitService 
{
	OrgUnit getOrgUnit(String idCDM);
	//retourne l'orgunit du CDM ayant pour programID idCDM
	//retourne null si le cdm n'a pas ete trouve
	
	OrgUnit updateOrgUnit(String idCDM, OrgUnit newOrgUnit);
	//remplace l'orgunit du cdm ayant pour programID idCDM
	//retourne null si le cdm n'a pas ete trouve
}
