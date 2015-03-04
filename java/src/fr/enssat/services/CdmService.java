package fr.enssat.services;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;


public interface CdmService  {
	
	public List<CDM> findAll();
	public void uploadCDM(CDM cdm);
	public List<Course> getAllCourses();
	public void addCourse(Course c);
	public void deleteCourseById(String ident);
	public void updateLevelByCourseId(String ident,String newValue);
	public void updateTeachingTermOfCourseById (String ident,String newValue);
	public Program getProgram();
	public OrgUnit getOrgUnit();
	
	/*les fonctions qu'il faudrait faire dans cette classe selon moi
	 * public List <CDM> findAll();
		//retourne l'ensemble des CDM en base
		
		
		public CDM findByID(String idCDM);
		//retourne le cours ayant pour id IDCourse
		//retourne null si le cdm n'est pas trouve
		 
		public CDM updateCDM (String idCDM,CDM newCDM);
		//remplace le cours selectionne par newCourse et retourne findByID(idCDM) ou null si le cdm n'a pas ete trouv� 
		
		public void addCDM(CDM newCDM);
		//ajoute un CDM
		//retourne null si le CDM existe deja (et ne modifie pas le modele)
		
		public void supprimeCDM(String idCDM);
		retourne le CDM supprime ou null si le cdm n'a pas ete trouve
	 */
}
