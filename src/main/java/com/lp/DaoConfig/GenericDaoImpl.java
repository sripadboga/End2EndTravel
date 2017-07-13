package com.lp.DaoConfig;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<E> extends HibernateDaoSupport implements CurdsDaoInterface<E>{

	@Autowired
	SessionFactory sessionFactory;
	private final Class<E> entityClass;

	private DataIntegrityViolationException sqlException = new DataIntegrityViolationException("Duplicate Record inserted");


	public GenericDaoImpl() {
		this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/*protected Session getSession() {
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}*/
	
	@Autowired
    public void setSession(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
    }

	/*@Override
	public E findById(final Serializable id) {
		
		return (E) getHibernateTemplate().get(this.entityClass, id);
	}

	@Override
	public Serializable save(E entity) {
		return getHibernateTemplate().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public void delete(E entity) {
		getHibernateTemplate().delete(entity);
	}


	@Override
	public List<E> findAll() {
		return getSession().createCriteria(this.entityClass).list();
	}

	@Override
	public List<E> getListByCriteria(DetachedCriteria detachedCriteria) {
        return (List<E>) getHibernateTemplate().findByCriteria(detachedCriteria); 
    }

	@Override
	public void clear() {
		getSession().clear();

	}

	@Override
	public void flush() {
		getSession().flush();

	}*/
	
	@Override
	 public List<E> findAll() throws Exception{
         Session session = getHibernateTemplate().getSessionFactory().openSession();
         List<E> list = session.createQuery("from "+entityClass.getName()).list();
         session.close();
         return list;
     }

	@Override
     public void delete(E domain) throws Exception {

             Session session = sessionFactory.openSession();
             Transaction tx = session.beginTransaction();

             session.delete(domain);
             tx.commit();
             session.close();

     }
	
	@Override
	public void deleteAll() throws Exception {
		List<E> entities = findAll();
		for (E entity : entities) {
			getHibernateTemplate().delete(entity);
		}
	}

	@Override
     public Long saveOrUpdate(E domain) throws Exception {

         try {
             Session session = sessionFactory.openSession();
             Transaction tx = session.beginTransaction();

             session.saveOrUpdate(domain);
             tx.commit();
             Serializable ids = session.getIdentifier(domain);
             session.close();
             return (Long)ids;

         } catch (ConstraintViolationException  e) {
        	 throw new ConstraintViolationException("Duplicate Records Found",(Set<? extends ConstraintViolation<?>>) sqlException);
         } 

     }
	
	@Override
	public List<E> findAllByExample(E entity) {
		Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
		 Session session = sessionFactory.openSession();
		return session.createCriteria(this.entityClass).add(example).list();
	}

	@Override
     public void saveOrUpdate(List domainList) throws Exception {
         try {
             Session session = sessionFactory.openSession();
             Transaction tx = session.beginTransaction();

             Object dom  = null;

             for(int i =0; i<domainList.size(); i++) {

                 dom = domainList.get(i);
                 session.saveOrUpdate(dom);

                  if ( i % 10 == 0 ) { 
                       //10, same as the JDBC batch size
                       //flush a batch of inserts and release memory:
                      session.flush();
                      session.clear();
                  }

             }

             tx.commit();
             session.close();

         } catch (ConstraintViolationException  e) {
             throw new ConstraintViolationException("Duplicate Records Found",(Set<? extends ConstraintViolation<?>>) sqlException);
         } 

     }

	@Override
	public E findById(final Serializable id) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		E o = (E) session.get(entityClass, id);
		return (E)o;
	}

	@Override
     public List<E> getListByCriteria(DetachedCriteria detachedCriteria) {
         return (List<E>) getHibernateTemplate().findByCriteria(detachedCriteria);
     }
	

}
