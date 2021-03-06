package Repository;

import java.util.ArrayList;

import Model.Exercicio;
import Util.*;

public class RepositorioExercicio implements CRUD<Exercicio> {

	private static ArrayList<Exercicio> list = new ArrayList<>();

	@Override
	public boolean adicionar(Exercicio obj) {
		return list.add(obj);
	}

	@Override
	public ArrayList<Exercicio> buscar(String nome) {
		ArrayList<Exercicio> listResult = new ArrayList<>();
		
		for(Exercicio obj: list)
			if( obj.getNome().equals(nome) )
				listResult.add(obj);
				
		return listResult;
	}

	@Override
	public boolean editar(String nome, Exercicio obj) {
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