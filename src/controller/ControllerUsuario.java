package controller;

import model.Exercicio;
import model.Refeicao;
import model.Usuario;
import model.dao.connection.HandlerObject;
import util.*;
import validation.CredenciaisInvalidasException;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;
import validation.UsuarioDuplicadoException;

import java.util.ArrayList;

public class ControllerUsuario {

	private static HandlerObject handlerObject = HandlerObject.getInstance();
	private static Usuario usuarioLogado;

	
	
	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	
	public static boolean adicionar(Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException, UsuarioDuplicadoException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel concluir cadastro! Objeto Usuario null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel concluir cadastro! Nome vazio");
		else if(obj.getUsuario().equals(""))
			throw new DadosVaziosException("Imposs�vel concluir cadastro! Campo usu�rio vazio");
		else if(obj.getSenha().equals(""))
			throw new DadosVaziosException("Imposs�vel concluir cadastro! Senha vazia");
		else if(!obj.getSenha().equals(obj.getConfirmaSenha()))
			throw new SenhaInvalidaException("Imposs�vel concluir cadastro! As senhas n�o coincidem");
		else {
			try {
				buscar(obj.getUsuario());
				throw new UsuarioDuplicadoException("Imposs�vel concluir cadastro! Usu�rio digitado j� esta cadastrado");
			} catch (NullPointerException e) {
				if(!handlerObject.create(obj))
					throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel concluir cadastro! Erro ao tentar adicionar o usuario '"+obj.getNome()+"' ao repositorio");
				else
					return true;
			}
		} 
	}


	public static Usuario buscar(String usuario) throws DadosVaziosException, NullPointerException {
		if(usuario != null && usuario.equals(""))
			throw new DadosVaziosException("Imposs�vel buscar! Campo usu�rio vazio");
		
		Usuario user = handlerObject.read(Usuario.class, "usuario", usuario);
		
		if(user == null)
			throw new NullPointerException("N�o foi poss�vel encontrar usuarios a partir do nome de usuario");
		else 
			return user;
			
	}


	public static boolean editar() throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException {
		if(usuarioLogado == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Usuario null");
		else if(usuarioLogado.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(usuarioLogado.getUsuario().equals(""))
			throw new DadosVaziosException("Imposs�vel concluir cadastro! Campo usu�rio vazio");
		else if(usuarioLogado.getSenha().equals(""))
			throw new DadosVaziosException("Imposs�vel concluir cadastro! Senha vazia");
		else if(!usuarioLogado.getSenha().equals(usuarioLogado.getConfirmaSenha()))
			throw new SenhaInvalidaException("Imposs�vel concluir cadastro! As senhas n�o coincidem");
		else if(!handlerObject.update(Usuario.class, usuarioLogado))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o usuario '"+usuarioLogado.getNome()+"' no repositorio");
		else 
			return true;
	}


	public static boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!handlerObject.delete(nome))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir o usuario '"+nome+"' no repositorio");
		else 
			return true;
	}
	
	/* -----------------------------
	 * 		M�todos do dominio
	 * -----------------------------*/
	
	/**
	 * 
	 * @param nome
	 * @param senha
	 * @throws CredenciaisInvalidasException 
	 */
	public static boolean validarLogin(String usuario, String senha) throws CredenciaisInvalidasException {
		
		try {
			Usuario user = buscar(usuario);
			
			if( !user.getSenha().equals(senha) || !user.getUsuario().equals(usuario))
				throw new CredenciaisInvalidasException("Login ou senha inv�lidos");
			user.setConfirmaSenha(senha);
			
			if(user.getListRefeicao() == null)
				user.setListRefeicao(new ArrayList<>());
			
			if(user.getListExercicio() == null)
				user.setListExercicio(new ArrayList<>());
			
			usuarioLogado = user;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new NullPointerException("Nenhum usuario encontrado");
		} catch (DadosVaziosException e) {
			e.printStackTrace();
			throw new NullPointerException("Dados vazios");
		}		
		
		return true;
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
	
	public static void removerCaloriasGastas(int kcal) {	
		usuarioLogado.decCaloriasGastas(kcal);
	}
	
	public static void atualizarUsuarioLogado() throws NullPointerException, DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, SenhaInvalidaException {	
		editar();
	}

}