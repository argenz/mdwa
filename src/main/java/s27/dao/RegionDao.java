package s27.dao;

import java.util.List;

import org.hibernate.Session;

public class RegionDao {
    public List<Region> getAll() {    //definisci il metodo getAll
    	
        try (Session session = HibernateUtil.getSessionFactory().openSession()) { //crei la sessione attraverso questi due metodi. 
            return session.createQuery("from Region", Region.class).list();  //from region (select all è sottointeso), Region.class ritorna la classe Region in se'. 
            
            //quindi qua dice prendi i dati dentro alla tabella region e definiscili come Regioni, definite nella classe Region. 
        }
    }
}
