package controller;

import java.util.ArrayList;

public interface IAlimentacao<T> {

	/**
	 * 
	 * @param glutem
	 * @param lactose
	 * @param taxaAcucar
	 */
	ArrayList<T> buscar(boolean glutem, boolean lactose, int taxaAcucar);

}