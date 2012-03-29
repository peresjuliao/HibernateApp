package br.com.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	
	public void save(T object);
	public void update(T object);
	public T findById(Serializable id);
	public List<T> findAll();
	public void delete(T object);
	

}