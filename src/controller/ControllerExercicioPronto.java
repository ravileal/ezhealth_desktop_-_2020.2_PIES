package controller;

import java.util.ArrayList;
import java.util.List;

import model.Exercicio;
import model.ExercicioPronto;
import model.dao.connection.HandlerObject;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;

public class ControllerExercicioPronto {
	
	private static HandlerObject handlerObject = HandlerObject.getInstance();
	
	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	public static List<ExercicioPronto> buscarTodos() throws NullPointerException {
		List<ExercicioPronto> list = handlerObject.readAll(ExercicioPronto.class);
		
		if(list == null || list.size() == 0)
			throw new NullPointerException("Nenhuam exercicio encontrada");
		
		return list;
	}
	
	
	public static ExercicioPronto buscar(int id) throws DadosVaziosException, NullPointerException {
		ExercicioPronto user = handlerObject.read(ExercicioPronto.class, id);
		
		if(user == null)
			throw new NullPointerException("N�o foi poss�vel encontrar exercicios a partir do nome de exercicio");
		else 
			return user;
	}
	
	public boolean adicionar(ExercicioPronto obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel salvar exercicio! Objeto Exercicio null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel salvar exercicio! Nome vazio");
		else {
			return handlerObject.create(obj);
		} 
	}




	public static boolean editar(ExercicioPronto obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Exercicio null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!handlerObject.update(ExercicioPronto.class, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o exercicio '"+obj.getNome()+"' no repositorio");
		else 
			return true;
	}


	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!handlerObject.delete(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir o exercicio '"+nome+"' no repositorio");
		else {
			return true;
		}
	}
}
