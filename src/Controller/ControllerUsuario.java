package Controller;

import Util.*;

import java.util.ArrayList;

import Model.Exercicio;
import Model.Refeicao;
import Model.Usuario;
import Repository.RepositorioRefeicao;
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
	public boolean adicionar(Usuario obj) {
		return (obj.getNome().equals("") || obj.getSenha().equals(""))?
			 false : rep.adicionar(obj);
	}

	@Override
	public ArrayList<Usuario> buscar(String nome) {
		return (nome.equals(""))? null: rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Usuario obj) {
		return (nome.equals(""))? false: rep.editar(nome, obj);
	}

	@Override
	public boolean remover(String nome) {
		return (nome.equals(""))? false: rep.remover(nome);
	}
	
	/* -----------------------------
	 * 		Métodos do dominio
	 * -----------------------------*/
	
	/**
	 * 
	 * @param nome
	 * @param senha
	 */
	public boolean validarLogin(String usuario, String senha) {
		// TODO - implement ControllerUsuario.validarLogin
		
		ArrayList<Usuario> list = rep.buscar(usuario);
		if(list.size() == 0)
			return false;
		
		Usuario u = rep.buscar(usuario).get(0);
		
		if( u == null 
		|| !u.getSenha().equals(senha) 
		|| !u.getUsuario().equals(usuario)
		) return false;
		
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