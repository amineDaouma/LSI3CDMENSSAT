package fr.enssat.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CourseList 
{
	
	List<Course> courseList;

	public List<Course> getListe() 
	{
		return courseList;
	}

	public void setListe(List<Course> liste) 
	{
		this.courseList = liste;
	}

	public CourseList(List<Course> liste) 
	{
		super();
		this.courseList = liste;
	}
	
	public CourseList() 
	{
		
	}
	
	
	
	

}
