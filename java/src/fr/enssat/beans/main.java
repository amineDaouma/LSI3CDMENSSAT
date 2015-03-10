package fr.enssat.beans;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import fr.enssat.beans.WebLink;


public class main {
	
	public main(){
		super();
	}

	
	public static void main(String[] args) {
		
		WebLink link = new WebLink();
		
		link.setHref("xu.com");
		link.setLinkName("handll");

		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(link);
		
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

}
