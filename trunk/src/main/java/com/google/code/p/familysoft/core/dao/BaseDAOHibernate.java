package com.google.code.p.familysoft.core.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("baseDAO")
public abstract class BaseDAOHibernate<T, ID extends Serializable> 
	extends HibernateDaoSupport
	implements BaseDAO<T, ID>{

	private Class<T> persistentClass;
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public BaseDAOHibernate() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
	                        .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock)
		    entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
		else
		    entity = (T) getSession().load(getPersistentClass(), id);
	
		return entity;
	}

	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example =  Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
		    example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	public T makePersistent(T entity) {
		getSession().saveOrUpdate(entity);
		return entity;
	}

	public void makeTransient(T entity) {
		getSession().delete(entity);
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	* Use this inside subclasses as a convenience method.
	*/
	@SuppressWarnings("unchecked")
	protected List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
		    crit.add(c);
		}
		return crit.list();
	}
	
	@Resource(name="sessionFactory")    
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
