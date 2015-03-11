package fr.enssat.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import fr.enssat.beans.CDM;


//Remarque concernant l'ensemble de la DAO :
//J'ai essaye d'implementer le session-per-request pattern qui est tres adapte a notre situation 
//si mon implementation est incorrecte, cela signifie qu'on utilise tout le temps la meme session,ce qui est degueulasse mais ca marche quand-meme
//si j'ai bien compris le patern : 
//1. ON NE CREE PAS A CHAQUE FOIS UNE SESSION FACTORY ! C'est tres gourmand et deconseille
//2. on n'utilise pas openSession mais getCurrentSession() qui utilisera la session en cours si il y en a une d'ouverte ou ouvrira une seesion sinon
//3. comme notre session a ete ouverte par getCurentSession, un simpel commit fermera la session
public class CdmDAOImpl implements CdmDAO{
	
	
	// voir : https://developer.jboss.org/wiki/SessionsAndTransactions?_sscc=t
	private static final SessionFactory sessionFactory;  
	  
    static {  
        try {  
            // Create the SessionFactory from hibernate.cfg.xml  
            sessionFactory = new Configuration().configure().buildSessionFactory();  
        } catch (Throwable ex) {  
            // Make sure you log the exception, as it might be swallowed  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
  
	
    
    //Pour les simples get, le pb du lazy se pose : 
    //Les objets utilises ne sont pas reellement charges tant qu'on ne les utilise pas
    //Ainsi, les objets sont lies à la session et si on ferme la session avant de les retourner, les objets n'ont pas reellement ete charges et on obtient l'erreur suivante : 
    //"failed to lazily initialize a collection of role :  no session or session was closed"
    //Pour corriger cela, on peut faire passer le lazy à false, mais cela est deconseille
    //source : www.developpez.net/forums/d1243882/java/developpement-web-java/frameworks/no-session-or-session-was-closed/
    
    //pour l'instant, la session reste ouverte tant qu'il n'y a pas de methode differante du get ...
    //pour faire qqc de plus correcte : https://docs.jboss.org/hibernate/stable/core.old/reference/fr/html/performance.html (voir 19.1.1 19.1.2, ...)
	@SuppressWarnings("unchecked")
	@Override
	public List<CDM> findAll() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> retour = (List<CDM>) (session.createQuery("from CDM").list());
		return retour;
	}

	@Override
	public CDM findByID(String idCDM) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List<CDM> cdms = findAll();
		for (CDM cdm : cdms) {
			if(cdm.getProgram().getProgramID().equals(idCDM)){
				return cdm;
			}
		}
		return null;
		
	}

	@Override
	public CDM updateCDM(String idCDM, CDM newCDM) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		CDM cdm=findByID(idCDM);
		if(cdm!=null){
			newCDM.setHjid(cdm.getHjid());				
			session.merge(newCDM);				
			session.getTransaction().commit();			
			return newCDM;			
		}
		return null;
	}

	@Override
	public CDM addCDM(CDM newCDM) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		CDM cdm=findByID(newCDM.getProgram().getProgramID());
		if(cdm==null){
			session.save(newCDM);		
			session.getTransaction().commit();		
			return newCDM;
		}else{
			return null;
		}
	}

	@Override
	public CDM addCDM(String newCDM) {
		// TODO Auto-generated method stub
		//recupere une version xml du cdm sous forme de string, l;unmarshal et appelle addCDM(CDM newCDM)
		return null;
	}

	@Override
	public CDM supprimeCDM(String idCDM) {
		
		
		CDM cdm=findByID(idCDM);
		if(cdm!=null){
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(cdm);		
			session.getTransaction().commit();		
			return cdm;
		}else{
			return null;
		}
		
		
	}

}
