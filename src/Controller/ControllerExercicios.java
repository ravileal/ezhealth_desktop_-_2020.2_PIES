package Controller;

import java.util.ArrayList;

import Model.Exercicio;
import Repository.RepositorioExercicio;
import Repository.RepositorioExercicioRealizado;
import Util.*;

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
	 * 		Métodos do CRUD
	 * -----------------------------*/
	
	@Override
	public boolean adicionar(Exercicio obj) {
		return (obj.getNome().equals(""))? false : 
		(exercicioRealizado)? repRealizada.adicionar(obj) : rep.adicionar(obj);
	}

	@Override
	public ArrayList<Exercicio> buscar(String nome) {
		return (nome.equals(""))? null: 
		(exercicioRealizado)? repRealizada.buscar(nome) : rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Exercicio obj) {
		return (nome.equals(""))? false: 
		(exercicioRealizado)? repRealizada.editar(nome, obj) : rep.editar(nome, obj);
	}

	@Override
	public boolean remover(String nome) {
		return (nome.equals(""))? false: 
		(exercicioRealizado)? repRealizada.remover(nome) : rep.remover(nome);
	}
}