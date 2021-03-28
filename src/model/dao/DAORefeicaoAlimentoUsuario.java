package model.dao;


import java.util.List;

import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.RefeicaoAlimentoUsuario;
import model.dao.connection.HandlerObject;

public class DAORefeicaoAlimentoUsuario extends HandlerObject {
	
	public RefeicaoAlimentoUsuario readIdUsuario(String string) {
		object = null;
		connection.execute(
			(Session session, Transaction transaction) -> {
				object = session.byNaturalId(RefeicaoAlimentoUsuario.class).using("idUsuario", string).load();
			}
		);
		return (RefeicaoAlimentoUsuario) object;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> List<T> readIdUsuarioAll(Class<T> class1, String string) {
		connection.execute(
			(Session session, Transaction transaction) -> {
			    CriteriaBuilder builder = session.getCriteriaBuilder();
			    CriteriaQuery<T> criteria = builder.createQuery(class1);
			    
			    Root<T> root = criteria.from(class1);
			    criteria.where(builder.equal( root.get("idUsuario"), string));
			    
			    list = (List<Object>) session.createQuery(criteria).getResultList();
			}
		);
		return (List<T>) list;
	}
	
	@SuppressWarnings("unchecked")
	public <T,K> List<T> readIdRefeicaoAll(Class<T> class1, String string) {
		connection.execute(
			(Session session, Transaction transaction) -> {
			    CriteriaBuilder builder = session.getCriteriaBuilder();
			    CriteriaQuery<T> criteria = builder.createQuery(class1);
			    
			    Root<T> root = criteria.from(class1);
			    criteria.where(builder.equal( root.get("idRefeicao"), string));
			    
			    list = (List<Object>) session.createQuery(criteria).getResultList();
			}
		);
		return (List<T>) list;
	}
	
	public RefeicaoAlimentoUsuario readIdRefeicao(String string) {
		object = null;
		connection.execute(
			(Session session, Transaction transaction) -> {
				object = session.byNaturalId(RefeicaoAlimentoUsuario.class).using("idRefeicao", string).load();
			}
		);
		return (RefeicaoAlimentoUsuario) object;
	}

	public <T> boolean delete(String idRefeicao) {	
		return connection.execute(
			(Session session, Transaction transaction) -> {
				while(readIdRefeicao(idRefeicao) != null) {
					session.remove(object);
					transaction.commit();					
				}
				System.out.println("successfully deleted");
			}
		);
	}
	
}
