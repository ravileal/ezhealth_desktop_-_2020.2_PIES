package model.dao.connection;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HandlerObject {
	
	private Connection connection = Connection.getInstance();
	private static volatile Object object;
	private static volatile List<Object> list;
	private static HandlerObject instance;
	
	public static HandlerObject getInstance() {
		if(instance == null)
			instance = new HandlerObject();
		return instance;
	}
	
	public <T> boolean create(T obj) {		
		return connection.execute((Session session, Transaction transaction) -> {
				session.save(obj);
				transaction.commit();
				System.out.println("successfully saved");	
			}
		);
	}
    
	@SuppressWarnings("unchecked")
	public <T,K> List<T> readAll(Class<T> class1) {
		connection.execute(
			(Session session, Transaction transaction) -> {
			    CriteriaBuilder builder = session.getCriteriaBuilder();
			    CriteriaQuery<T> criteria = builder.createQuery(class1);
			    criteria.from(class1);
			    list = (List<Object>) session.createQuery(criteria).getResultList();
			}
		);
		return (List<T>) list;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> T readUser(Class<T> class1, K id) {
		connection.execute(
			(Session session, Transaction transaction) -> {
				object = (id instanceof String)?
						session.byNaturalId(class1).using("usuario", id).load():
						session.find(class1, id);
			}
		);
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> T read(Class<T> class1, K id) {
		connection.execute(
			(Session session, Transaction transaction) -> {
				object = (id instanceof String)?
						session.byNaturalId(class1).using("nome", id).load():
						session.find(class1, id);
			}
		);
		return (T) object;
	}
	
	public <T, K> boolean update(Class<T> class1, T objectUpdate) {	
		return connection.execute(
			(Session session, Transaction transaction) -> {
				session.update(object);
				transaction.commit();
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