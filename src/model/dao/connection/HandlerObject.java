package model.dao.connection;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Model;

public class HandlerObject {
	
	private Connection connection = Connection.getInstance();
	private static volatile Object object;
	private static volatile List listObject;
	private static HandlerObject instance;
	
	public static HandlerObject getInstance() {
		if(instance == null)
			instance = new HandlerObject();
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> T read(Class<T> class1, int id) {
		connection.execute(
				(Session session, Transaction transaction) -> {
					object = null;
					object = session.find(class1, id);
				}
			);
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> T read(Class<T> class1, String fildName, K value) {
		connection.execute(
			(Session session, Transaction transaction) -> {
				object = null;
			    String[] separator = class1.getName().split("\\.");
			    String className = separator[separator.length-1];
			    
			    TypedQuery query = session.createQuery("from "+className+" where "+fildName+"='"+value+"'");
				object = (T) query.getSingleResult();
			}
		);
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> readAll(Class<T> class1) {
		connection.execute(
			(Session session, Transaction transaction) -> {
				listObject = null;
			    String[] separator = class1.getName().split("\\.");
			    String className = separator[separator.length-1];
			    
			    TypedQuery query = session.createQuery("from "+className);
			    listObject = query.getResultList();
			}
		);
		return listObject;
	}
	
	
	
	public <T> boolean create(T obj) {		
		return connection.execute((Session session, Transaction transaction) -> {
				if(transaction != null)
					transaction.rollback();
				transaction = session.beginTransaction();
				session.save(obj);
				transaction.commit();
				System.out.println("successfully saved");	
			}
		);
	}
	
	
	public <T extends Model> boolean update(Class<T> class1, T objectUpdate) {	
		return connection.execute(
			(Session session, Transaction transaction) -> {
				if(transaction != null)
					transaction.rollback();
				transaction = session.beginTransaction();
				T object = session.find(class1, objectUpdate.getId());
				session.evict(object);

				object = objectUpdate;
				session.saveOrUpdate(object);
				try {
					transaction.commit();
				} catch(NonUniqueObjectException e){
					e.printStackTrace();
				}
				
				System.out.println("successfully updated");
			}
		);
	}
	
	public <T> boolean delete(T object) {	
		return connection.execute(
			(Session session, Transaction transaction) -> {
				session.remove(object);
				transaction.commit();
				System.out.println("successfully deleted");
			}
		);
	}
}