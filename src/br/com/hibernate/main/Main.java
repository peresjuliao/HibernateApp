package br.com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.com.hibernate.modelo.Produto;
import br.com.hibernate.modelo.Usuario;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new AnnotationConfiguration()
			.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")  
			.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")  
			.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate")  
			.setProperty("hibernate.connection.username", "root")  
			.setProperty("hibernate.connection.password", "root")  
			.setProperty("hibernate.show_sql", "true")  
			.setProperty("hibernate.format_sql", "true")    
			.setProperty("hibernate.c3p0.acquire_increment", "1")                          
			.setProperty("hibernate.c3p0.idle_test_period", "100")  
			.setProperty("hibernate.c3p0.max_size", "10")  
			.setProperty("hibernate.c3p0.max_statements", "0")  
			.setProperty("hibernate.c3p0.min_size", "5")  
			.setProperty("hibernate.c3p0.timeout", "100")
			.addAnnotatedClass(Usuario.class)
			.addAnnotatedClass(Produto.class)
			.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// The code
		
		// Buscando o usuario
//		Usuario usuario = (Usuario) session.get(Usuario.class, 2);
		
		Produto produto = (Produto) session.get(Produto.class, 1);
		
		System.out.println("O produto e do " + produto.getDono().getNome());
		
		// Criando o usuario
	//	Usuario usuario1 = new Usuario();
		
//		usuario.setNome("Mark C.");
//		session.update(usuario);
//		System.out.println("O nome do usuario e " + usuario.getNome());
		
		// Close
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();

	}

}
