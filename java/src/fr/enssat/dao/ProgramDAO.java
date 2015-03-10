package fr.enssat.dao;

import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;

public interface ProgramDAO {
	
	Program getProgram(String idCDM);
	//retourne le program li� au cmd identifi� par idCDM
	//retourne null si le cdm n'est pas trouve
	
	Program updateProgram(String idCDM, Program newProgram);
	//remplace e program li� au cmd identifi� par idCDM par newProgram
	//retourne null si le cdm n'a pas ete trouve
	
	SubProgram getSubProgram(String idCDM, String subProgramID);
	//retourne le subProgram lie au sub
	//retourne null  si le cdm ou le subProgram n'a pas ete trouve
	
	SubProgram addSubProgram(String idCDM, SubProgram subProgram);
	//ajoute le subProgram subProgram
	//retourne null si il existe deja un subProgram avec le meme id /ou\ si le cdm n'a pas ete trouve (et ne fait aucune modification du modele)
	
	SubProgram updateSubProgram(String idCDM, String idSubProgram , SubProgram newSubProgram);
	//remplace le Subprogram identifi� par idCDM et idSubProgram par newSubProgram
	//retourne null si le cdm n'a pas ete trouve
	
	SubProgram deleteSubProgram(String idCDM, String idSubProgram);
	//remplace le program li� au cmd identifi� par idCDM par newOrgUnit
	//retourne null si il existe deja un subProgram avec le meme id

}
