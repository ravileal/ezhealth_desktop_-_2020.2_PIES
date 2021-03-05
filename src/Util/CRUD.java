package Util;

import java.util.ArrayList;

public interface CRUD<T> {

	/**
	 * 
	 * @param obj
	 */
	boolean adicionar(T obj);

	/**
	 * 
	 * @param id
	 */
	ArrayList<T> buscar(String nome);

	/**
	 * 
	 * @param obj
	 */
	boolean editar(String nome, T obj);

	/**
	 * 
	 * @param id
	 */
	boolean remover(String id);

}