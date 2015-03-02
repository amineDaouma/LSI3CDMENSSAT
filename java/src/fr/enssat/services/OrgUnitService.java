package fr.enssat.services;

import fr.enssat.beans.OrgUnit;

public interface OrgUnitService 
{
	OrgUnit getOrgUnit(String idCDM);
	//retourne l'orgunit lié au cmd identifié par idCDM
	//retourne null si le cdm n'a pas ete trouve
	
	boolean updateOrgUnit(String idCDM, OrgUnit newOrgUnit);
	//remplace l'orgunit lie au cmd identifié par idCDM par newOrgUnit
	//retourne null si le cdm n'a pas ete trouve
}
