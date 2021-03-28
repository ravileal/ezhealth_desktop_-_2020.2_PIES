package model.dao.connection;

import java.util.List;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import model.Model;

public class HandlerObject {
	
	protected Connection connection = Connection.getInstance();
	protected static volatile Object object;
	protected static volatile List<Object> list;
	protected static HandlerObject instance;
	
	public static HandlerObject getInstance() {
		if(instance == null)
			instance = new HandlerObject();
		return instance;
	}
	
	public String create(Model obj) {	
		connection.execute((Session session, Transaction transaction) -> {
				object = null;
		        obj.setId(UUID.randomUUID().toString());
				session.save(obj);
				if (!transaction.getStatus().equals(TransactionStatus.ACTIVE))
					transaction = session.beginTransaction();
				transaction.commit();
				object = obj.getId();
				System.out.println("successfully saved");	
			}
		);
		return (String) object;
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
		connection.execute((Session session, Transaction transaction) -> {
			object = session.byNaturalId(class1).using("usuario", id).load();
		});
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> T readNome(Class<T> class1, String nome) {
		connection.execute((Session session, Transaction transaction) -> {
			object = session.byNaturalId(class1).using("nome", nome).load();
		});
		return (T) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> T read(Class<T> class1, K id) {
		connection.execute((Session session, Transaction transaction) -> {
			object = session.find(class1, id);
		});
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