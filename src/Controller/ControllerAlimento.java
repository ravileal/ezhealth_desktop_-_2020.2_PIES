package Controller;

import java.util.ArrayList;

import Model.Alimento;
import Util.*;

public class ControllerAlimento implements IAlimentacao<Alimento>, CRUD<Alimento> {

	private ControllerAlimento rep;
	
	public ControllerAlimento() {
		rep = new ControllerAlimento();
	}
	
	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	@Override
	public boolean adicionar(Alimento obj) {
		return (obj.getNome().equals(""))? false : rep.adicionar(obj);
	}

	@Override
	public ArrayList<Alimento> buscar(String nome) {
		return (nome.equals(""))? null: rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Alimento obj) {
		return (nome.equals(""))? false: rep.editar(nome, obj);
	}

	@Override
	public boolean remover(String nome) {
		return (nome.equals(""))? false: rep.remover(nome);
	}

	@Override
	public ArrayList<Alimento> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
		// TODO Auto-generated method stub
		return null;
	}
}