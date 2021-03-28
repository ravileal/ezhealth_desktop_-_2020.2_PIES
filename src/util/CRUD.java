package util;

import java.util.List;

import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;
import validation.SenhaInvalidaException;
import validation.UsuarioDuplicadoException;

public interface CRUD<T> {

	/**
	 * 
	 * @param obj
	 * @throws DadosVaziosException 
	 * @throws OperacaoNaoConcluidaRepositorioExeception 
	 * @throws SenhaInvalidaException 
	 * @throws UsuarioDuplicadoException 
	 */
	boolean adicionar(T obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException, UsuarioDuplicadoException;

	/**
	 * 
	 * @param id
	 * @throws DadosVaziosException 
	 */
	T buscar(String nome) throws DadosVaziosException;

	List<T> buscarTodos() throws DadosVaziosException;
	
	/**
	 * 
	 * @param obj
	 * @throws DadosVaziosException 
	 * @throws OperacaoNaoConcluidaRepositorioExeception 
	 * @throws SenhaInvalidaException 
	 * @throws NullPointerException 
	 */
	boolean editar(String nome, T obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException, SenhaInvalidaException;

	/**
	 * 
	 * @param id
	 * @throws DadosVaziosException 
	 * @throws OperacaoNaoConcluidaRepositorioExeception 
	 */
	boolean remover(String id) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception;

}