package Repository;

import java.util.ArrayList;

import Model.Alimento;
import Util.*;

public class RepositorioAlimento implements CRUD<Alimento> {

	private static ArrayList<Alimento> list = new ArrayList<>();

	@Override
	public boolean adicionar(Alimento obj) {
		return list.add(obj);
	}

	@Override
	public ArrayList<Alimento> buscar(String nome) {
		ArrayList<Alimento> listResult = new ArrayList<>();
		
		for(Alimento obj: list)
			if( obj.getNome().equals(nome) )
				listResult.add(obj);
				
		return listResult;
	}

	@Override
	public boolean editar(String nome, Alimento obj) {
		return (list.set(getIdForName(nome), obj) != null)? true: false;
	}

	@Override
	public boolean remover(String nome) {
		return (list.remove(getIdForName(nome)) != null)? true: false;
	}
	
	private int getIdForName(String nome) {
		for(int i=0; i<list.size(); i++)
			if( list.get(i).getNome().equals(nome) )
				return i;
		return -1;
	}
	
}