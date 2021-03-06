package Repository;

import java.util.ArrayList;

import Model.Usuario;
import Util.*;

public class RepositorioUsuario implements CRUD<Usuario> {

	private static ArrayList<Usuario> list;
	
	public RepositorioUsuario() {
		list = new ArrayList<>();
		
		Usuario u = new Usuario();
		u.setUsuario("admin");
		u.setSenha("admin");
		list.add(u);
	}

	@Override
	public boolean adicionar(Usuario obj) {
		return list.add(obj);
	}

	@Override
	public ArrayList<Usuario> buscar(String usuario) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> listResult = new ArrayList<>();
		
		for(Usuario u: list)
			if( u.getUsuario().equals(usuario) )
				listResult.add(u);
				
		return listResult;
	}

	@Override
	public boolean editar(String usuario, Usuario obj) {
		// TODO Auto-generated method stub
		return (list.set(getIdForUsuario(usuario), obj) != null)? true: false;
	}

	@Override
	public boolean remover(String usuario) {
		// TODO Auto-generated method stub
		return (list.remove(getIdForUsuario(usuario)) != null)? true: false;
	
	}
	
	private int getIdForUsuario(String usuario) {
		for(int i=0; i<list.size(); i++)
			if( list.get(i).getUsuario().equals(usuario) )
				return i;
		return -1;
	}

}
