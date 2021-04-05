package controller;

import java.util.List;

import model.AlimentoPronto;
import model.dao.connection.HandlerObject;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;

public class ControllerAlimentoPronto {
	
	private static HandlerObject handlerObject = HandlerObject.getInstance();
	
	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	public static List<AlimentoPronto> buscarTodos() throws NullPointerException {
		List<AlimentoPronto> list = handlerObject.readAll(AlimentoPronto.class);
		
		if(list == null || list.size() == 0)
			throw new NullPointerException("Nenhuam alimento encontrado");
		
		return list;
	}
	
	
	public static AlimentoPronto buscar(int id) throws DadosVaziosException, NullPointerException {
		AlimentoPronto user = handlerObject.read(AlimentoPronto.class, id);
		
		if(user == null)
			throw new NullPointerException("N�o foi poss�vel encontrar alimento");
		else 
			return user;
	}
	
	public boolean adicionar(AlimentoPronto obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel salvar alimento! Objeto Alimento null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel salvar alimento! Nome vazio");
		else {
			return handlerObject.create(obj);
		} 
	}




	public static boolean editar(AlimentoPronto obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Alimento null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!handlerObject.update(AlimentoPronto.class, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o alimento '"+obj.getNome()+"' no repositorio");
		else 
			return true;
	}


	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!handlerObject.delete(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir o alimento '"+nome+"' no repositorio");
		else {
			return true;
		}
	}
}
