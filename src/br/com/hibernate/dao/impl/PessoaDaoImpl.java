package br.com.hibernate.dao.impl;

import br.com.hibernate.dao.GenericDaoImpl;
import br.com.hibernate.modelo.Pessoa;

public class PessoaDaoImpl extends GenericDaoImpl<Pessoa, Long> {

	public PessoaDaoImpl(Class<Pessoa> persistentClass) {
		super(persistentClass);
		// TODO Auto-generated constructor stub
	}
	
}
