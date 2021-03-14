package Util;

import java.util.ArrayList;

import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;
import Validation.SenhaInvalidaException;
import Validation.UsuarioDuplicadoException;

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
	ArrayList<T> buscar(String nome) throws DadosVaziosException;

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