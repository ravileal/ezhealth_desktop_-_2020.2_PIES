package Repository;

import java.util.ArrayList;

import Model.Usuario;
import Util.*;

public class RepositorioUsuario implements CRUD<Usuario> {

	private static ArrayList<Usuario> list = new ArrayList<>();

	
	@Override
	public boolean adicionar(Usuario obj) {
		return list.add(obj);
	}

	@Override
	public ArrayList<Usuario> buscar(String usuario) {
		if(usuario == null) return RepositorioUsuario.list;
		ArrayList<Usuario> listResult = new ArrayList<Usuario>();
		
		for(Usuario u: list)
			if( u.getUsuario().equals(usuario) )
				listResult.add(u);
		
		return (listResult.size() == 0)? null: listResult;
	}

	@Override
	public boolean editar(String usuario, Usuario obj) {
		return (list.set(getIdForUsuario(usuario), obj) != null)? true: false;
	}

	@Override
	public boolean remover(String usuario) {
		int index = getIdForUsuario(usuario);
		if(index == -1) return false;
		return (list.remove(index) != null)? true: false;
	}
	
	private int getIdForUsuario(String usuario) {
		for(int i=0; i<list.size(); i++)
			if( list.get(i).getUsuario().equals(usuario) )
				return i;
		return -1;
	}

}
