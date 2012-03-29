package br.com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;

import br.com.hibernate.util.HibernateUtil;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements
		GenericDAO<T, Serializable> {

	private Session session;
	private Transaction transaction;
	private Class<T> persistentClass; 
	
	public GenericDaoImpl(Class<T> persistentClass) {
		this.session = HibernateUtil.getSessionFactory().openSession();
		this.persistentClass = persistentClass;		
	}	

	@Override
	public void save(T object) {		
		transaction = session.beginTransaction();
		session.save(object);
		transaction.commit();
	}

	@Override
	public void update(T object) {		
		transaction = session.beginTransaction();
		session.update(object);
		transaction.commit();
	}

	@Override
	public void delete(T object) {		
		transaction = session.beginTransaction();
		session.delete(object);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		return (T) session.load(persistentClass, id);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> resultList = null;
		resultList = session.createCriteria(persistentClass).list();
		return resultList;
	}

}
