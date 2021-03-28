package controller;

import java.util.ArrayList;

import model.Alimento;
import model.AlimentoModel;
import model.RefeicaoAlimentoUsuario;
import model.dao.DAORefeicaoAlimentoUsuario;
import model.dao.connection.HandlerObject;
import repository.RepositorioAlimento;
import util.*;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

public class ControllerAlimento  {

	private RepositorioAlimento rep;
	private static HandlerObject handlerObject = HandlerObject.getInstance();

	public ControllerAlimento() {
		Popular.getInstance();
		rep = new RepositorioAlimento();
	}

	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	public String adicionar(Alimento obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Impossível adicionar! Objeto Alimento null"); 
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível adicionar! Nome vazio");
		
		String id = handlerObject.create(obj);
		
		if(id == null)
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível adicionar! Erro ao tentar adicionar o alimento '"+obj.getNome()+"' ao repositorio");
		else 
			return id;
	}

	public ArrayList<AlimentoModel> buscarTodosModel() throws DadosVaziosException, NullPointerException {
		ArrayList<AlimentoModel> list = (ArrayList<AlimentoModel>) handlerObject.readAll(AlimentoModel.class);
		
		if(list == null)
			throw new NullPointerException("Não foi possível encontrar exercicio a partir do nome");
		else 
			return list;
	}
	
	
	public ArrayList<Alimento> buscarTodos() throws DadosVaziosException, NullPointerException {
		ArrayList<Alimento> list = (ArrayList<Alimento>) handlerObject.readAll(Alimento.class);
		
		if(list == null)
			throw new NullPointerException("Não foi possível encontrar exercicio a partir do nome");
		else 
			return list;
	}
	
	public Alimento buscar(String id) throws DadosVaziosException, NullPointerException {
		if(id != null && id.equals(""))
			throw new DadosVaziosException("Impossível buscar! Id vazio");
		
		Alimento alimento = handlerObject.read(Alimento.class, id);
		
		if(alimento == null)
			throw new NullPointerException("Não foi possível encontrar exercicio a partir do id");
		else 
			return alimento;
	}

	public boolean editar(String nome, Alimento obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Impossível editar! Objeto Alimento null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível editar! Nome vazio");
		else if(!rep.editar(nome, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível editar! Erro ao tentar editar o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}

	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Impossível excluir! Nome vazio");
		else if(!rep.remover(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível excluir! Erro ao tentar excluir o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}
	
	

//	@Override
//	public ArrayList<Alimento> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}