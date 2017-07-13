package com.lp.DaoConfig;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface CurdsDaoInterface<E> {


	/**
	* 
	* @param entity: entity to save
	* @return Identifier of saved entity
	*//*
	Serializable save(E entity);*/
	
	/**
	* 
	* @param entity:entity to save or update
	 * @return 
	 * @throws Exception 
	*/
	public Long saveOrUpdate(E entity) throws Exception;
	
	/**
	* 
	* @param entity: entity to delete
	 * @throws Exception 
	*/
	void delete( E entity ) throws Exception;
	
	/**
	* Delete all records
	 * @throws Exception 
	*/
	void deleteAll() throws Exception;
	
	/**
	* Find all records
	* @return
	 * @throws Exception 
	*/
	List<E> findAll() throws Exception;
	
	/**
	* Find all records matching provided entity
	* @param entity: entity object used for search
	* @return
	*/
	List<E> findAllByExample( E entity );
	
	/**
	* Find by primary key
	* @param id
	* @return unique entity 
	*/
	E findById( Serializable id );
	
	
	/**
	* 
	* @param detachedCriteria
	* @return unique list of entity 
	*/
	List<E> getListByCriteria(DetachedCriteria detachedCriteria);
	
	/**
	* Find all records matching provided entity
	* @param listEntity: list of entities object used for search
	* @return
	*/
	
	void saveOrUpdate(List domainList) throws Exception;

	
}
