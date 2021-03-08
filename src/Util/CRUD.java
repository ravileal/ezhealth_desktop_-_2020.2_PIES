package Util;

import java.util.ArrayList;

import Validation.DadosVaziosException;
import Validation.ImpossivelAdicionarRepositorioExeception;

public interface CRUD<T> {

	/**
	 * 
	 * @param obj
	 * @throws DadosVaziosException 
	 * @throws ImpossivelAdicionarRepositorioExeception 
	 */
	boolean adicionar(T obj) throws DadosVaziosException, ImpossivelAdicionarRepositorioExeception;

	/**
	 * 
	 * @param id
	 */
	ArrayList<T> buscar(String nome);

	/**
	 * 
	 * @param obj
	 * @throws DadosVaziosException 
	 * @throws ImpossivelAdicionarRepositorioExeception 
	 */
	boolean editar(String nome, T obj) throws DadosVaziosException, ImpossivelAdicionarRepositorioExeception;

	/**
	 * 
	 * @param id
	 * @throws DadosVaziosException 
	 * @throws ImpossivelAdicionarRepositorioExeception 
	 */
	boolean remover(String id) throws DadosVaziosException, ImpossivelAdicionarRepositorioExeception;

}