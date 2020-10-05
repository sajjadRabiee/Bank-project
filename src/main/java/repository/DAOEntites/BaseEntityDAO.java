package repository.DAOEntites;

import repository.DAOFactory.EMF;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class BaseEntityDAO<Entity , ID extends Number> {
    protected abstract Class<Entity> getEntityClass();
    protected abstract String getFieldName();
    //find
    public Optional<Entity> findById(ID id) {
        EntityManager em = EMF.getEntityManager();
        Entity obj;
        try{
            obj = em.find(getEntityClass() ,id);
        }catch(NoResultException e) {
            obj = null;
        }
        em.close();
        return obj != null ? Optional.of(obj) : Optional.ofNullable(null);
    }

    public Optional<Entity> findByName(String str) {
        EntityManager em = EMF.getEntityManager();
        Entity obj;
        try{
            TypedQuery<Entity> query = em.createQuery("select e from "+getEntityClass().getName()+" e where e."+getFieldName()+" = \'"+str+"\'",getEntityClass());
            obj = query.getSingleResult();
        }catch (NoResultException e){
            obj = null;
        }
        em.close();
        return obj != null ? Optional.of(obj) : Optional.ofNullable(null);
    }

    public List<Entity> findAll(Predicate<Entity> p){
        EntityManager em = EMF.getEntityManager();
        TypedQuery<Entity> query = em.createQuery("select e from "+getEntityClass().getName()+" e",getEntityClass());
        List<Entity> objects = query.getResultList();
        return objects.stream().filter(p).collect(Collectors.toList());
    }

    //add
    public Boolean add(Entity entity) {
        EntityManager em = EMF.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally {
            em.close();
        }
    }

    //update
    public Boolean update(Entity entity) {
        EntityManager em = EMF.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally{
            em.close();
        }
    }

    //delete
    public Boolean delete(Entity entity) {
        EntityManager em = EMF.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }finally {
            em.close();
        }
    }
}
