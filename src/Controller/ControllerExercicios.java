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
		this.rep = new RepositorioExercicio();
		this.repRealizada = new RepositorioExercicioRealizado();
		this.exercicioRealizado = exercicioRealizado;
	}
	
	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	
	@Override
	public boolean adicionar(Exercicio obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(obj == null)
			throw new NullPointerException("Imposs�vel adicionar! Objeto Exercicio null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel adicionar! Nome vazio");
		else if(!(exercicioRealizado)? repRealizada.adicionar(obj) : rep.adicionar(obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel adicionar! Erro ao tentar adicionar o exercicio '"+obj.getNome()+"' ao repositorio");
		else 
			return true;
	}

	@Override
	public ArrayList<Exercicio> buscar(String nome) {
		return (nome.equals(""))? null: 
		(exercicioRealizado)? repRealizada.buscar(nome) : rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Exercicio obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Exercicio null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!(exercicioRealizado)? repRealizada.editar(nome, obj) : rep.editar(nome, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o exercicio '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!(exercicioRealizado)? repRealizada.remover(nome) : rep.remover(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}
}