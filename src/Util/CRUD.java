package Util;

import java.util.ArrayList;

import Validation.DadosVaziosException;
import Validation.OperacaoNaoConcluidaRepositorioExeception;

public interface CRUD<T> {

	/**
	 * 
	 * @param obj
	 * @throws DadosVaziosException 
	 * @throws OperacaoNaoConcluidaRepositorioExeception 
	 */
	boolean adicionar(T obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception;

	/**
	 * 
	 * @param id
	 */
	ArrayList<T> buscar(String nome);

	/**
	 * 
	 * @param obj
	 * @throws DadosVaziosException 
	 * @throws OperacaoNaoConcluidaRepositorioExeception 
	 */
	boolean editar(String nome, T obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception;

	/**
	 * 
	 * @param id
	 * @throws DadosVaziosException 
	 * @throws OperacaoNaoConcluidaRepositorioExeception 
	 */
	boolean remover(String id) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception;

}