package fr.enssat.dao;

import fr.enssat.beans.OrgUnit;

public interface OrgUnitDAO {
	OrgUnit getOrgUnit(String idCDM);
	//retourne l'orgunit li� au cmd identifi� par idCDM
	//retourne null si le cdm n'a pas ete trouve
	
	OrgUnit updateOrgUnit(String idCDM, OrgUnit newOrgUnit);
	//remplace l'orgunit lie au cmd identifi� par idCDM par newOrgUnit
	//retourne null si le cdm n'a pas ete trouve
}


