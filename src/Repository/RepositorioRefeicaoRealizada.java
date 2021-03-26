package Repository;

import java.util.ArrayList;

import Model.Refeicao;
import Util.*;

public class RepositorioRefeicaoRealizada implements CRUD<Refeicao> {

	private static ArrayList<Refeicao> list = new ArrayList<>();

	@Override
	public boolean adicionar(Refeicao obj) {
		return list.add(obj);
	}

	@Override
	public ArrayList<Refeicao> buscar(String nome) {
		if(nome == null) return RepositorioRefeicaoRealizada.list;
		ArrayList<Refeicao> listResult = new ArrayList<>();
		
		for(Refeicao obj: list)
			if( obj.getNome().equals(nome) )
				listResult.add(obj);
				
		return  (listResult.size() == 0)? null: listResult;
	}

	@Override
	public boolean editar(String nome, Refeicao obj) {
		return (list.set(getIdForName(nome), obj) != null)? true: false;
	}

	@Override
	public boolean remover(String nome) {
		int index = getIdForName(nome);
		if(index == -1) return false;
		return (list.remove(index) != null)? true: false;
	}
	
	private int getIdForName(String nome) {
		for(int i=0; i<list.size(); i++)
			if( list.get(i).getNome().equals(nome) )
				return i;
		return -1;
	}
}