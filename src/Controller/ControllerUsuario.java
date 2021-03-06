package Controller;

import Util.*;

import java.util.ArrayList;

import Model.Exercicio;
import Model.Refeicao;
import Model.Usuario;
import Repository.RepositorioUsuario;

public class ControllerUsuario implements CRUD<Usuario> {

	RepositorioUsuario rep = new RepositorioUsuario();
	
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

	@Override
	public boolean adicionar(Usuario obj) {
		if(obj.getNome().equals("") || obj.getSenha().equals(""))
			return false;
		// TODO Auto-generated method stub
		return rep.adicionar(obj);
	}

	@Override
	public ArrayList<Usuario> buscar(String nome) {
		// TODO Auto-generated method stub
		if(nome.equals(""))
			return null;
		return rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Usuario obj) {
		if(nome.equals(""))
			return false;
		// TODO Auto-generated method stub
		return rep.editar(nome, obj);
	}

	@Override
	public boolean remover(String nome) {
		if(nome.equals(""))
			return false;
		// TODO Auto-generated method stub
		return rep.remover(nome);
	}

}