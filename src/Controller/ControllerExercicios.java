package Controller;

import java.util.ArrayList;

import Model.Exercicio;
import Repository.RepositorioExercicio;
import Repository.RepositorioExercicioRealizado;
import Util.*;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

public class ControllerExercicios implements CRUD<Exercicio> {

	private RepositorioExercicio rep;
	private RepositorioExercicioRealizado repRealizada;
	private boolean exercicioRealizado;
	
	public ControllerExercicios(boolean exercicioRealizado) {
		Popular.getInstance();
		this.rep = new RepositorioExercicio();
		this.repRealizada = new RepositorioExercicioRealizado();
		this.exercicioRealizado = exercicioRealizado;
	}
	
	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	
	@Override
	public boolean adicionar(Exercicio obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Impossível adicionar! Objeto Exercicio null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível adicionar! Nome vazio");
		else if(!(exercicioRealizado)? repRealizada.adicionar(obj) : rep.adicionar(obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível adicionar! Erro ao tentar adicionar o exercicio '"+obj.getNome()+"' ao repositorio");
		else 
			return true;
	}

	@Override
	public ArrayList<Exercicio> buscar(String nome) throws DadosVaziosException, NullPointerException {
		if(nome != null && nome.equals(""))
			throw new DadosVaziosException("Impossível buscar! Nome vazio");
		
		ArrayList<Exercicio> list = (exercicioRealizado)? repRealizada.buscar(nome) : rep.buscar(nome);
		
		if(list == null)
			throw new NullPointerException("Não foi possível encontrar exercicio a partir do nome");
		else 
			return list;
		
	}

	@Override
	public boolean editar(String nome, Exercicio obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Impossível editar! Objeto Exercicio null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível editar! Nome vazio");
		else if(!(exercicioRealizado)? repRealizada.editar(nome, obj) : rep.editar(nome, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível editar! Erro ao tentar editar o exercicio '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Impossível excluir! Nome vazio");
		else if(!((exercicioRealizado)? repRealizada.remover(nome) : rep.remover(nome)))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível excluir! Erro ao tentar excluir o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}
}