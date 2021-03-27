package model.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connection {
	
	public interface Query {
		public void executeQuery(Session session, Transaction transaction);
	}
	
	private StandardServiceRegistry ssr;
	private Metadata meta;

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	private static Connection instance;
	
	public static Connection getInstance() {
		if(instance == null) 
			instance = new Connection();
		return instance;
	}

	private void setConfiguration() {
		ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		meta = new MetadataSources(ssr).getMetadataBuilder().build();
		factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	public void execute(Query query) {
		setConfiguration();
		try {
			query.executeQuery(session, transaction);		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();			
		}
	}
	
}
