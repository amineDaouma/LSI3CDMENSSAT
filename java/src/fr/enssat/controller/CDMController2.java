package fr.enssat.controller;

import java.util.List;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.CourseList;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.beans.SubProgram;
import fr.enssat.services.CDMService2;
import fr.enssat.services.CDMServiceImpl2;
import fr.enssat.services.CourseService;
import fr.enssat.services.CourseServiceImpl;
import fr.enssat.services.OrgUnitService;
import fr.enssat.services.OrgUnitServiceImpl;
import fr.enssat.services.ProgramService;
import fr.enssat.services.ProgramServiceImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cdms")
public class CDMController2 {
	private CDMService2 service = new CDMServiceImpl2(); // Service li� aux cdms
	CourseService courseService = new CourseServiceImpl(); // Service li� aux
															// cours
	OrgUnitService orgUnitService = new OrgUnitServiceImpl();
	ProgramService programService = new ProgramServiceImpl();

	// Fonctions relatives aux cdms

	// retourner Liste des cdms
	// risque de le pas marcher si on ne rajoute pas une classe listeCDM dans
	// les beans
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<CDM> findAllCDM()
	{
		return service.findAll();
	}

	// retourner un cdm
	@Path("/{idCDM}")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response findCDMByID(@PathParam("idCDM") String idCDM)
	{
		CDM cdm = service.findByID(idCDM);
		Response retour;
		if (cdm != null) 
		{
			retour = Response.status(200).entity(cdm).build();
		} 
		else
		{
			retour = Response.status(404).build();
		}
		return retour;
	}

	// ajouter un cdm
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response addCDM(CDM newCDM) 
	{
		System.out.println(newCDM.getProgram().getProgramID());
		CDM cdm = service.addCDM(newCDM);

		if (cdm != null)
		{
			return Response.status(202).build();
		} 
		else
		{
			return Response.status(404).build();
		}
	}

	@Path("/{idCDM}")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateCDM(CDM newCDM)
	{
		System.out.println(newCDM.getProgram().getProgramID());
		CDM cdm = service.addCDM(newCDM);

		if (cdm != null)
		{
			return Response.status(202).build();
		} 
		else
		{
			return Response.status(404).build();
		}
	}

	// supprime un CDM
	@Path("/{idCDM}")
	@DELETE
	public Response deleteCDM(@PathParam("idCDM") String idCDM) 
	{
		Response retour;
		if (service.supprimeCDM(idCDM) != null) 
		{
			retour = Response.status(200).build();
		} 
		else
		{
			retour = Response.status(404).build();
		}

		return retour;
	}

	// Chemins relatifs aux cours

	@Path("/{idCDM}/courses")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Response findAllCourses(@PathParam("idCDM") String idCDM)
	{
		CourseList listeRetour = courseService.findAll(idCDM);
		Response retour;
		if (listeRetour != null) 
		{
			retour = Response.status(200).entity(listeRetour).build();
		}
		else 
		{
			retour = Response.status(404).build();
		}
		return retour;
	}

	@Path("/{idCDM}/courses/{idCourse}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCDMByID(@PathParam("idCDM") String idCDM,
			@PathParam("idCourse") String idCourse)
	{
		Course course = courseService.findByID(idCDM, idCourse);
		Response retour;
		if (course != null) 
		{
			retour = Response.status(200).entity(course).build();
		}
		else 
		{
			retour = Response.status(404).build();
		}
		return retour;
	}

	@Path("/{idCDM}/courses")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCourse(@PathParam("idCDM") String idCDM, Course newCourse) 
	{
		System.out.println(newCourse.getIdent());
		Course course = courseService.addCourse(idCDM, newCourse);
		if (course != null) 
		{
			return Response.status(200).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}

	@Path("/{idCDM}/courses/{idCourse}")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response updateCourse(@PathParam("idCDM") String idCDM,
			@PathParam("idCourse") String idCourse, Course newCourse) 
	{
		System.out.println("test updatecourse");
		Course course = courseService.updateCours(idCDM, idCourse, newCourse);
		if (course != null) 
		{
			return Response.status(202).build();
		} 
		else
		{
			return Response.status(404).build();
		}
	}

	@Path("/{idCDM}/courses/{idCourse}")
	@DELETE
	public Response deleteCourse(@PathParam("idCDM") String idCDM,
			@PathParam("idCourse") String idCourse) 
	{
		System.out.println("test updatecourse");
		Course course = courseService.removeCourse(idCDM, idCourse);
		if (course != null) 
		{
			return Response.status(202).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}

	// Methodes relatives aux orgunit

	@Path("/{idCDM}/OrgUnit")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public OrgUnit getOrgUnit(@PathParam("idCDM") String idCDM) 
	{
		return orgUnitService.getOrgUnit(idCDM);
	}

	@Path("/{idCDM}/OrgUnit")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrgUnit(@PathParam("idCDM") String idCDM,OrgUnit newOrgUnit) 
	{
		OrgUnit retour = orgUnitService.updateOrgUnit(idCDM, newOrgUnit);
		
		if (retour != null) 
		{
			return Response.status(200).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}

	
	// Methodes relatives aux program

	@Path("/{idCDM}/Program")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Program getProgram(@PathParam("idCDM") String idCDM) 
	{
		return programService.getProgram(idCDM);
	}
	
	
	
	@Path("/{idCDM}/Program")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProgram(@PathParam("idCDM") String idCDM, Program newProgram) 
	{
		Program program = programService.updateProgram(idCDM, newProgram);
		
		
		if (program != null) 
		{
			return Response.status(202).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}
	
	
	@Path("/{idCDM}/Program/{subProgramID}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SubProgram getSubProgram(@PathParam("idCDM") String idCDM, @PathParam("subProgramID") String subProgramID) 
	{
		return programService.getSubProgram(idCDM, subProgramID);
	}
	
	@Path("/{idCDM}/Program/{subProgramID}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateSubProgram(@PathParam("idCDM") String idCDM, @PathParam("subProgramID") String subProgramID, SubProgram newSubProgram) 
	{
		SubProgram subProgram = programService.updateSubProgram(idCDM, subProgramID, newSubProgram);
		
		
		if (subProgram != null) 
		{
			return Response.status(202).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}
	
	
	@Path("/{idCDM}/Program")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSubProgram(@PathParam("idCDM") String idCDM, SubProgram newSubProgram) 
	{
		SubProgram subProgram = programService.addSubProgram(idCDM, newSubProgram);
		
		
		if (subProgram != null) 
		{
			return Response.status(202).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}
	
	
	@Path("/{idCDM}/Program/{subProgramID}")
	@DELETE
	public Response deleteSubProgram(@PathParam("idCDM") String idCDM, @PathParam("subProgramID") String subProgramID) 
	{
		SubProgram subProgram = programService.deleteSubProgram(idCDM, subProgramID);
		
		
		if (subProgram != null) 
		{
			return Response.status(202).build();
		}
		else 
		{
			return Response.status(404).build();
		}
	}
	
	
	
	

}
