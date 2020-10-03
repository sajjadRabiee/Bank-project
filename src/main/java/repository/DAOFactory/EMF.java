package repository.DAOFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-unit");
    private static EntityManager entityManager;

    private EMF(){

    }

    public static EntityManager getEntityManager(){
        if (entityManager==null){
            entityManager = entityManagerFactory.createEntityManager() ;
        }
        return entityManager;
    }

}
