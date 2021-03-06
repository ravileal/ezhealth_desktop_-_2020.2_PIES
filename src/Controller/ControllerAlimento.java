package Controller;

import java.util.ArrayList;

import Model.Refeicao;
import Util.*;

public class ControllerAlimento implements IAlimentacao<Refeicao>, CRUD<Refeicao> {

	@Override
	public boolean adicionar(Refeicao obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Refeicao> buscar(String nome) {
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

	@Override
	public ArrayList<Refeicao> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
		// TODO Auto-generated method stub
		return null;
	}
}