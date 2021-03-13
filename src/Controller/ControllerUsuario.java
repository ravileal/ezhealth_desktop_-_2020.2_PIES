package Controller;

import Util.*;
import Validation.CredenciaisInvalidasException;
import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;
import Validation.SenhaInvalidaException;
import Validation.UsuarioDuplicadoException;

import java.util.ArrayList;

import Model.Exercicio;
import Model.Refeicao;
import Model.Usuario;
import Repository.RepositorioUsuario;

public class ControllerUsuario implements CRUD<Usuario> {

	private static RepositorioUsuario rep = new RepositorioUsuario();
	
	private static Usuario usuarioLogado;
	
	public ControllerUsuario() {
//		try { // usuario de teste
//			usuarioLogado = this.buscar("Admin").get(0);
//		} catch (NullPointerException | DadosVaziosException e) {e.printStackTrace();}
	}
	
	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	@Override
	public boolean adicionar(Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException, UsuarioDuplicadoException {
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
				if(!rep.adicionar(obj))
					throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel concluir cadastro! Erro ao tentar adicionar o usuario '"+obj.getNome()+"' ao repositorio");
				else
					return true;
			}
		} 
	}

	@Override
	public ArrayList<Usuario> buscar(String usuario) throws DadosVaziosException, NullPointerException {
		if(usuario != null && usuario.equals(""))
			throw new DadosVaziosException("Imposs�vel buscar! Campo usu�rio vazio");
		
		ArrayList<Usuario> list = rep.buscar(usuario);
		
		if(list == null)
			throw new NullPointerException("N�o foi poss�vel encontrar usuarios a partir do nome de usuario");
		else 
			return list;
			
	}

	@Override
	public boolean editar(String nome, Usuario obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Usuario null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!rep.editar(nome, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o usuario '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Imposs�vel excluir! Nome vazio");
		else if(!rep.remover(nome))
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
		
		ArrayList<Usuario> list = rep.buscar(usuario);
		if(list == null)
			throw new NullPointerException("Nenhum usuario encontrado");
		
		Usuario u = rep.buscar(usuario).get(0);
		if( u == null )
			throw new NullPointerException("Usuario n�o encontrado");
		else if( !u.getSenha().equals(senha) || !u.getUsuario().equals(usuario))
			throw new CredenciaisInvalidasException("Login ou senha inv�lidos");
		
		usuarioLogado = u;
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

}