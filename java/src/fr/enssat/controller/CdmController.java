package fr.enssat.controller;

import java.io.StringReader;
import java.util.List;













import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.services.CdmService;
import fr.enssat.services.CdmServiceImpl;


@Path("/cdm")
public class CdmController {

	private CdmService service = new CdmServiceImpl();
	public CdmController() {
		super();
	}
	
	@GET
	public List<CDM> findAll(){
		return service.findAll();
	}
	
	
	@POST
	@Path("/upload")
	public void uploadCDM(String data){
		try {
			JAXBContext context = JAXBContext.newInstance(CDM.class);
			Unmarshaller u = context.createUnmarshaller();
			CDM cdm = (CDM) u.unmarshal(new StringReader(data));
			service.uploadCDM(cdm);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/getCourses")
	@Produces(MediaType.TEXT_XML)
	public List<Course> getCourses(){
		return service.getAllCourses();
	}
	
	@GET
	@Path("/getProgram")
	@Produces(MediaType.TEXT_XML)
	public Program getProgram(){
		return service.getProgram();
	}
	@GET
	@Path("/getOrg")
	@Produces(MediaType.TEXT_XML)
	public OrgUnit getOrgUnit(){
		return service.getOrgUnit();
	}
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test(){
		return "hello";
		
	}
	
	@POST
	@Path("/add")
	public void addCourse(@FormParam("ident") String ident,
						   @FormParam("level") String level,
						   @FormParam("teachingTerm") String teachingTerm){
	    Course c = new Course();

	    /*String cName=null;
	    String code=null;
	    String codeSet=null;
	    String creditContent=null;
	    String ectsCredits=null;
	    List<SubBlock> subBlockDescription=null;
	    List<SubBlock> subBlockLearning=null;
	    List<SubBlock> subBlockRecommended=null;
	    List<SubBlock> subBlockFormal=null;
	    List<SubBlock> subBlockSyllabus=null;
	    InfoBlock infoBlock=null;
	    TeachingPlace teachingPlace=null;
	    
	    
	    
	    
	    Text courseName= new Text();   
	    courseName.setText(cName);
	    CourseCode courseCode= new CourseCode();
	    courseCode.setValue(code);
	    courseCode.setCodeSet(codeSet);
	    CourseDescription courseDescription = new CourseDescription();//?	    
		courseDescription.setSubBlock(subBlockDescription);	    
	    Credits credits = new Credits();
	    credits.setContent(creditContent);
	    credits.setECTScredits(ectsCredits);
	    LearningObjectives learningObjectives= new LearningObjectives(); //?
		learningObjectives.setSubBlock(subBlockLearning);
	    
	    RecommendedPrerequisites recommendedPrerequisites= new RecommendedPrerequisites();//?
		recommendedPrerequisites.setSubBlock(subBlockRecommended);
	    FormalPrerequisites formalPrerequisites= new FormalPrerequisites();
		formalPrerequisites.setSubBlock(subBlockFormal);
	    Syllabus syllabus= new Syllabus();
		syllabus.setSubBlock(subBlockSyllabus);
	    TeachingActivity teachingActivity= new TeachingActivity();
		teachingActivity.setInfoBlock(infoBlock);
	    c.setCourseName(courseName);
	    c.setCourseCode(courseCode);
	    c.setCourseDescription(courseDescription);
	    c.setCredits(credits);
	    c.setLearningObjectives(learningObjectives);
	    c.setRecommendedPrerequisites(recommendedPrerequisites);
	    c.setFormalPrerequisites(formalPrerequisites);
		c.setTeachingPlace(teachingPlace);
	    c.setSyllabus(syllabus);
	    c.setTeachingActivity(teachingActivity);*/
	    
	    
	    
	    c.setId(ident);
	    c.setIdent(ident);
	    c.setLevel(level);
	    c.setTeachingTerm(teachingTerm);
		service.addCourse(c);
	}
	
	@DELETE
	@Path("/delete/{ident}")
	public void deleteCourseById(@PathParam("ident") String ident){
		service.deleteCourseById(ident);
	
	}
	
	@PUT
	@Path("/updateL/{ident}/{newValue}")
	public void updateLevelCourseById(@PathParam("ident") String ident,@PathParam("newValue") String newValue){
		
		service.updateLevelByCourseId(ident,newValue);
	
	}
	
	@PUT
	@Path("/updateT/{ident}/{newValue}")
	public void updateTeachingTermOfCourseById(@PathParam("ident") String ident,@PathParam("newValue") String newValue){
		
		service.updateTeachingTermOfCourseById(ident,newValue);
	
	}
	
	
	
	

}
