package fr.enssat.controller;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;
import fr.enssat.services.CourseService;
import fr.enssat.services.CourseServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/cdms")
public class CDMController2 
{
	private CDMService2 service = new CDMServiceImpl2(); //Service lié aux cdms
	CourseService courseService = new CourseServiceImpl(); //Service lié aux cours
	
	//Fonctions relatives aux cdms
	
	// retourner Liste des cdms
	//risque de le pas marcher si on ne rajoute pas une classe listeCDM dans les beans
	@Path("")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CDM> findAllCDM_JSON() 
	{
		return service.findAll();
	}
	
	//retourner un cdm
	@Path("/{idCDM}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCDMByID(@PathParam("idCDM") String idCDM) 
	{
		CDM cdm =service.findByID(idCDM);
		Response retour;
		if(cdm!=null)
		{
			retour = Response.status(200).entity(cdm).build();
		}
		else
		{
			retour = Response.status(404).build();
		}
		return retour;
	}
	
	//ajouter un cdm
	//!!! prend une chaine de caraceres en entree
	@Path("")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addCDM(String newCDM)
	{
		CDM cdm = service.addCDM(newCDM);

		if (cdm!=null) 
		{
			return Response.status(202).build();
		} 
		else
		{
			return Response.status(404).build();
		}
	}
	
	
	@Path("/{idCDM}")
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateCDM(String newCDM)
	{
		CDM cdm = service.addCDM(newCDM);

		if (cdm!=null) 
		{
			return Response.status(202).build();
		} 
		else
		{
			return Response.status(404).build();
		}
	}
	
	
	//supprime un CDM
	@Path("/{idCDM}")
	@DELETE
	public Response deleteCDM(@PathParam("idCDM") String idCDM) 
	{
		Response retour;
		if(service.supprimeCDM(idCDM)!=null)
		{
			retour = Response.status(200).build();
		}
		else
		{
			retour = Response.status(404).build();
		}
		
		return retour;
	}
	
	
	//Chemins relatifs aux cours
	
	@Path("/{idCDM}/courses")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> findAllCourses(@PathParam("idCDM") String idCDM) 
	{
		return courseService.findAll(idCDM);
	}
	
	
	@Path("/{idCDM}/courses/{idCourse}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCDMByID(@PathParam("idCDM") String idCDM,@PathParam("idCourse") String idCourse) 
	{
		CDM cdm =service.findByID(idCDM);
		Response retour;
		if(cdm!=null)
		{
			retour = Response.status(200).entity(cdm).build();
		}
		else
		{
			retour = Response.status(404).build();
		}
		return retour;
	}
	
	
}
