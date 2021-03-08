package Controller;

import Util.*;
import Validation.CredenciaisInvalidasException;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

import java.util.ArrayList;

import Model.Exercicio;
import Model.Refeicao;
import Model.Usuario;
import Repository.RepositorioUsuario;

public class ControllerUsuario implements CRUD<Usuario> {

	private RepositorioUsuario rep;
	
	public ControllerUsuario() {
		Popular.getInstance();
		rep = new RepositorioUsuario();
	}
	
	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	@Override
	public boolean adicionar(Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(obj == null)
			throw new NullPointerException("Impossível adicionar! Objeto Usuario null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível adicionar! Nome vazio");
		else if(obj.getSenha().equals(""))
			throw new DadosVaziosException("Impossível adicionar! Senha vazia");
		else if(!rep.adicionar(obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível adicionar! Erro ao tentar adicionar o usuario '"+obj.getNome()+"' ao repositorio");
		else 
			return true;
	}

	@Override
	public ArrayList<Usuario> buscar(String nome) {
		return (nome.equals(""))? null: rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(obj == null)
			throw new NullPointerException("Impossível editar! Objeto Usuario null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível editar! Nome vazio");
		else if(!rep.editar(nome, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível editar! Erro ao tentar editar o usuario '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Impossível excluir! Nome vazio");
		else if(!rep.remover(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível excluir! Erro ao tentar excluir o usuario '"+nome+"' no repositorio");
		else 
			return true;
	}
	
	/* -----------------------------
	 * 		Métodos do dominio
	 * -----------------------------*/
	
	/**
	 * 
	 * @param nome
	 * @param senha
	 * @throws CredenciaisInvalidasException 
	 */
	public boolean validarLogin(String usuario, String senha) throws CredenciaisInvalidasException {
		
		ArrayList<Usuario> list = rep.buscar(usuario);
		if(list.size() == 0)
			throw new NullPointerException("Nenhum usuario encontrado");
		
		Usuario u = rep.buscar(usuario).get(0);
		if( u == null )
			throw new NullPointerException("Usuario não encontrado");
		else if( !u.getSenha().equals(senha) || !u.getUsuario().equals(usuario))
			throw new CredenciaisInvalidasException("Login ou senha inválidos");
		
		return true;
	}

	/**
	 * 
	 * @param refeicao
	 * @param exercicio
	 */
	public void calculoObjetivoCalorias(Refeicao refeicao, Exercicio exercicio) {
		// TODO - implement ControllerUsuario.calculoObjetivoCalorias
		throw new UnsupportedOperationException();
	}

}