package controller;

import model.Exercicio;
import model.Refeicao;
import model.Usuario;
import model.dao.connection.HandlerObject;
import repository.RepositorioUsuario;
import util.*;
import validation.CredenciaisInvalidasException;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;
import validation.UsuarioDuplicadoException;

import java.util.ArrayList;
import java.util.List;

public class ControllerUsuario implements CRUD<Usuario> {

	private static RepositorioUsuario rep = new RepositorioUsuario();
	private static HandlerObject handlerObject = HandlerObject.getInstance();
	private static Usuario usuarioLogado;
	
	public ControllerUsuario() {
//		try { // usuario de teste
//			usuarioLogado = this.buscar("Admin").get(0);
//		} catch (NullPointerException | DadosVaziosException e) {e.printStackTrace();}
	}
	
	
	
	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	@Override
	public boolean adicionar(Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException, UsuarioDuplicadoException {
		if(obj == null)
			throw new NullPointerException("Impossível concluir cadastro! Objeto Usuario null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível concluir cadastro! Nome vazio");
		else if(obj.getUsuario().equals(""))
			throw new DadosVaziosException("Impossível concluir cadastro! Campo usuário vazio");
		else if(obj.getSenha().equals(""))
			throw new DadosVaziosException("Impossível concluir cadastro! Senha vazia");
		else if(!obj.getSenha().equals(obj.getConfirmaSenha()))
			throw new SenhaInvalidaException("Impossível concluir cadastro! As senhas não coincidem");
		else {
			try {
				buscar(obj.getUsuario());
				throw new UsuarioDuplicadoException("Impossível concluir cadastro! Usuário digitado já esta cadastrado");
			} catch (NullPointerException e) {
				if(!handlerObject.create(obj))
					throw new OperacaoNaoConcluidaRepositorioExeception("Impossível concluir cadastro! Erro ao tentar adicionar o usuario '"+obj.getNome()+"' ao repositorio");
				else
					return true;
			}
		} 
	}
	
	@Override
	public List<Usuario> buscarTodos() throws DadosVaziosException {
		return handlerObject.readAll(Usuario.class);
	}

	@Override
	public Usuario buscar(String usuario) throws DadosVaziosException, NullPointerException {
		if(usuario != null && usuario.equals(""))
			throw new DadosVaziosException("Impossível buscar! Campo usuário vazio");
		
		Usuario user = handlerObject.readUser(Usuario.class, usuario);
		
		if(user == null)
			throw new NullPointerException("Não foi possível encontrar usuarios a partir do nome de usuario");
		else 
			return user;
			
	}

	@Override
	public boolean editar(String nome, Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException {
		if(obj == null)
			throw new NullPointerException("Impossível editar! Objeto Usuario null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível editar! Nome vazio");
		else if(obj.getUsuario().equals(""))
			throw new DadosVaziosException("Impossível concluir cadastro! Campo usuário vazio");
		else if(obj.getSenha().equals(""))
			throw new DadosVaziosException("Impossível concluir cadastro! Senha vazia");
		else if(!obj.getSenha().equals(obj.getConfirmaSenha()))
			throw new SenhaInvalidaException("Impossível concluir cadastro! As senhas não coincidem");
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
	public static boolean validarLogin(String usuario, String senha) throws CredenciaisInvalidasException {
		
		Usuario user = handlerObject.readUser(Usuario.class, usuario);
		if(user == null)
			throw new NullPointerException("Nenhum usuario encontrado");
		else if( !user.getSenha().equals(senha) || !user.getUsuario().equals(usuario))
			throw new CredenciaisInvalidasException("Login ou senha inválidos");
		
		usuarioLogado = user;
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

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuario usuarioLogado) {
		ControllerUsuario.usuarioLogado = usuarioLogado;
	}
	
	public void adicionarCaloriasConsumidas(int kcal) {
		usuarioLogado.addCaloriasConsumidas(kcal);
	}
	
	public void removerCaloriasConsumidas(int kcal) {	
		usuarioLogado.decCaloriasConsumidas(kcal);
	}
	
	public void adicionarCaloriasGastas(int kcal) {
		usuarioLogado.addCaloriasGastas(kcal);
	}
	
	public void removerCaloriasGastas(int kcal) {	
		usuarioLogado.decCaloriasGastas(kcal);
	}

}