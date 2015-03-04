package fr.enssat.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;











import fr.enssat.beans.CDM;
import fr.enssat.beans.Course;
import fr.enssat.beans.CourseCode;
import fr.enssat.beans.CourseDescription;
import fr.enssat.beans.Credits;
import fr.enssat.beans.FormalPrerequisites;
import fr.enssat.beans.LearningObjectives;
import fr.enssat.beans.OrgUnit;
import fr.enssat.beans.Program;
import fr.enssat.beans.RecommendedPrerequisites;
import fr.enssat.beans.Syllabus;
import fr.enssat.beans.TeachingActivity;
import fr.enssat.beans.TeachingPlace;
import fr.enssat.beans.Text;
import fr.enssat.beans.WebLink;
import fr.enssat.util.HibernateUtil;

public class CdmDAOImpl implements CdmDAO {
	
	List<WebLink> list=new LinkedList<WebLink>();
	
	
	public CdmDAOImpl() {
		super();
	}
	
	public void uploadCDM(CDM cdm){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cdm);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<CDM> findAll(){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return (List<CDM>) (session.createQuery("from CDM").list());
	}
	
	@Override
	public void addCourse(Course c) {



		    
			SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(c);
			
				session.getTransaction().commit();

			/*List<WebLink> wbL = session.createQuery("from WebLink").list();
			Iterator<WebLink> it = wbL.iterator();
			while(it.hasNext()){
				WebLink wbl1 = it.next();
				System.out.println(wbl1.toString());
			}*/
			
			session.close();
			sessionFactory.close();


		
	}

	public List<Course> getAllCourses() {

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session.createQuery("from Course").list();
		
	}

	@Override
	public void deleteCourseById(String ident) {
		System.out.println("a: "+ident);
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		String hql = "delete from Course where ident= :ident";  
		session.createQuery(hql).setString("ident", ident).executeUpdate();
		session.getTransaction().commit();
	}
	
	public void updateLevelByCourseId(String ident,String newValue){
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "update Course set level=:newValue where ident= :ident";  
		session.createQuery(hql).setString("ident", ident).setString("newValue", newValue).executeUpdate();
		session.getTransaction().commit();		
		
	}

	@Override
	public void updateTeachingTermOfCourseById(String ident, String newValue) {
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql = "update Course set teachingTerm=:newValue where ident= :ident";  
		session.createQuery(hql).setString("ident", ident).setString("newValue", newValue).executeUpdate();
		session.getTransaction().commit();		
		
	}

	@Override
	public Program getProgram() {
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		return (Program) session.createQuery("from Program").list().get(0);
	}

	@Override
	public OrgUnit getOrgUnit() {
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		return (OrgUnit) session.createQuery("from OrgUnit").list().get(0);
	}

}
