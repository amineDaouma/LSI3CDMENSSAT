package fr.enssat.services;

import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;

public interface ProgramService 
{
	Program getProgram(String idCDM);
	//retourne le program du CDM ayant pour programID idCDM
	//retourne null si le cdm n'est pas trouve
	
	Program updateProgram(String idCDM, Program newProgram);
	//remplace e program du cdm ayant pour programID idCDM par newProgram
	//retourne null si le cdm n'a pas ete trouve
	
	SubProgram getSubProgram(String idCDM, String subProgramID);
	//retourne le subProgram ayant pour id subProgramID 
	//retourne null  si le cdm ou le subProgram n'a pas ete trouve
	
	SubProgram addSubProgram(String idCDM, SubProgram subProgram);
	//ajoute le subProgram subProgram au programme ayant pour programID idCDM
	//retourne null si il existe deja un subProgram avec le meme id /ou\ si le cdm n'a pas ete trouve (et ne fait aucune modification du modele)
	
	SubProgram updateSubProgram(String idCDM, String idSubProgram , SubProgram newSubProgram);
	
	//retourne null si le cdm n'a pas ete trouve
	
	SubProgram deleteSubProgram(String idCDM, String idSubProgram);
	//remplace le program lié au cmd identifié par idCDM par newOrgUnit
	//retourne null si il en'existe pas de subProgram ayant cet id
	
}
