package Controller;

import Util.*;

import java.util.ArrayList;
import java.util.Date;

import Model.*;

public class ControllerRefeicao implements CRUD<Refeicao>, IAlimentacao<Refeicao> {

	/**
	 * 
	 * @param dataIni
	 * @param dataFim
	 */
	public Refeicao buscar(Date dataIni, Date dataFim) {
		// TODO - implement ControllerRefeicao.buscar
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Refeicao> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean adicionar(Refeicao obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Refeicao> buscar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editar(String nome, Refeicao obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remover(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}