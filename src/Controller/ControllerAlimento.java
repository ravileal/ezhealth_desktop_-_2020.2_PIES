package Controller;

import java.util.ArrayList;

import Model.Alimento;
import Repository.RepositorioAlimento;
import Util.*;
import Validation.DadosVaziosException;
import Validation.ImpossivelAdicionarRepositorioExeception;

public class ControllerAlimento implements IAlimentacao<Alimento>, CRUD<Alimento> {

	private RepositorioAlimento rep;

	public ControllerAlimento() {
		rep = new RepositorioAlimento();
	}

	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	@Override
	public boolean adicionar(Alimento obj) throws DadosVaziosException, ImpossivelAdicionarRepositorioExeception {
		if(obj == null)
			throw new NullPointerException("Imposs�vel adicionar! Objeto Alimento null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel adicionar! Nome vazio");
		else if(!rep.adicionar(obj))
			throw new ImpossivelAdicionarRepositorioExeception("Imposs�vel editar! Erro ao tentar adicionar o alimento '"+obj.getNome()+"' ao repositorio");
		else 
			return true;
	}

	@Override
	public ArrayList<Alimento> buscar(String nome) {
		return (nome.equals("")) ? null : rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Alimento obj) throws DadosVaziosException, ImpossivelAdicionarRepositorioExeception {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Alimento null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!rep.editar(nome, obj))
			throw new ImpossivelAdicionarRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, ImpossivelAdicionarRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!rep.remover(nome))
			throw new ImpossivelAdicionarRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir o alimento '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public ArrayList<Alimento> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
		// TODO Auto-generated method stub
		return null;
	}
}