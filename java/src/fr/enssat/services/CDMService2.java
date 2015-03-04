package fr.enssat.services;

import java.util.List;

import fr.enssat.beans.CDM;

public interface CDMService2 
{
	public List<CDM> findAll();
	//retourne l'ensemble des CDM en base
	
	
	public CDM findByID(String idCDM);
	//retourne le cdm ayant pour programID idCDM
	//retourne null si le cdm n'est pas trouve
	 
	public CDM updateCDM (String idCDM,CDM newCDM);
	//remplace le CDM en base ayant pour programID idCDM
	//retourne null siil n'existe pas de tel CDM
	
	public CDM addCDM(CDM newCDM);
	//ajoute un CDM
	//retourne null si le CDM existe deja (et ne modifie pas le modele)
	
	public CDM addCDM(String newCDM);
	//unmarshall un cdm et utilise la fonction precedente
	//retourne le resultat de la fonction precedante ou null si l'unmarshall fail 
	
	
	public CDM supprimeCDM(String idCDM);
	//retourne le CDM supprime ou null si le cdm n'a pas ete trouve
}
