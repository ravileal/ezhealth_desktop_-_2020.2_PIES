package Repository;

import java.util.ArrayList;

import Model.Usuario;
import Util.*;

public class RepositorioUsuario implements CRUD<Usuario> {

	private static ArrayList<Usuario> list;
	
	public RepositorioUsuario() {
		list = new ArrayList<>();
		
		Usuario u = new Usuario();
		u.setNome("admin");
		u.setSenha("admin");
		list.add(u);
	}

	@Override
	public boolean adicionar(Usuario obj) {
		return list.add(obj);
	}

	@Override
	public ArrayList<Usuario> buscar(String nome) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> listResult = new ArrayList<>();
		
		for(Usuario u: list)
			if( u.getNome().equals(nome) )
				listResult.add(u);
				
		return listResult;
	}

	@Override
	public boolean editar(String nome, Usuario obj) {
		// TODO Auto-generated method stub
		return (list.set(getIdForName(nome), obj) != null)? true: false;
	}

	@Override
	public boolean remover(String nome) {
		// TODO Auto-generated method stub
		return (list.remove(getIdForName(nome)) != null)? true: false;
	
	}
	
	private int getIdForName(String nome) {
		for(int i=0; i<list.size(); i++)
			if( list.get(i).getNome().equals(nome) )
				return i;
		return -1;
	}

}
