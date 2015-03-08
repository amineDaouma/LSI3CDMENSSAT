package fr.enssat.dao;



import fr.enssat.beans.Course;
import fr.enssat.beans.CourseList;

public interface CourseDAO {
	public CourseList findAll(String idCDM);
	//retourne l'ensemble des cours d'un CDM identifie par idCDm
	//retourne null si le cdm n'a pas ete trouve
	
	
	public Course findByID(String idCDM, String IDCourse);
	//retourne le cours ayant pour id IDCourse 
	//retourne null si le cours n'a pas ete trouve
	
	public Course updateCours (String idCDM, String IDCourse, Course newCourse);
	//remplace le cours selectionne par newCourse et retourne findByID(idCDM, IDCourse)
	//retourne null si l'update a echoue
	
	public Course addCourse(String idCDM, Course newCourse);
	//ajoute un cours au cdm choisi
	//retourne null si un cours avec le meme id existe deja (et ne fait aucune modif du modele)
	
	public Course removeCourse(String IDCDM,String idCourse);
	//retourne le cours ayant pour id IDCourse 
	//retourne null si le cours n'a pas ete trouve

}
