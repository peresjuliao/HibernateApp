package br.com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.*;

import br.com.hibernate.util.HibernateUtil;

public abstract class GenericDaoImpl<T, ID extends Serializable> implements
		GenericDAO<T, Serializable> {

	private Session session;
	private Transaction transaction;
	protected abstract Class<T> getEntityClass();

	

	@Override
	public void save(T object) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(object);
		transaction.commit();
	}

	@Override
	public void update(T object) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(object);
		transaction.commit();
	}

	@Override
	public void delete(T object) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(object);
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		T entity;
		session = HibernateUtil.getSessionFactory().openSession();
		entity = (T) session.load(getEntityClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		List<T> resultList = null;
		session = HibernateUtil.getSessionFactory().openSession();
		resultList = session.createCriteria(getEntityClass()).list();
		return resultList;
	}

}
