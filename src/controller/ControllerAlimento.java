package controller;

import java.util.ArrayList;

import model.Alimento;
import model.dao.connection.HandlerObject;
import repository.RepositorioAlimento;
import util.*;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

public class ControllerAlimento implements CRUD<Alimento> {

	private RepositorioAlimento rep;
	private static HandlerObject handlerObject = HandlerObject.getInstance();

	public ControllerAlimento() {
		Popular.getInstance();
		rep = new RepositorioAlimento();
	}

	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	@Override
	public boolean adicionar(Alimento obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel adicionar! Objeto Alimento null"); 
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel adicionar! Nome vazio");
		else if(!rep.adicionar(obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel adicionar! Erro ao tentar adicionar o alimento '"+obj.getNome()+"' ao repositorio");
		else 
			return true;
	}


	public ArrayList<Alimento> buscarTodos() throws DadosVaziosException, NullPointerException {
		ArrayList<Alimento> list = (ArrayList<Alimento>) handlerObject.readAll(Alimento.class);
		
		if(list == null)
			throw new NullPointerException("N�o foi poss�vel encontrar exercicio a partir do nome");
		else 
			return list;
	}
	
	public Alimento buscar(String nome) throws DadosVaziosException, NullPointerException {
		if(nome != null && nome.equals(""))
			throw new DadosVaziosException("Imposs�vel buscar! Nome vazio");
		
		Alimento alimento = handlerObject.read(Alimento.class, nome);
		
		if(alimento == null)
			throw new NullPointerException("N�o foi poss�vel encontrar exercicio a partir do nome");
		else 
			return alimento;
	}

	@Override
	public boolean editar(String nome, Alimento obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Alimento null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!rep.editar(nome, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!rep.remover(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}

//	@Override
//	public ArrayList<Alimento> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}