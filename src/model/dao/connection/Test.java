package model.dao.connection;

import java.util.ArrayList;

import model.Alimento;
import model.Refeicao;
import model.Usuario;

public class Test {
	
	public static void main(String[] args) {
		Connection.getInstance().startConnection();
		
		Usuario user = HandlerObject.getInstance().read(Usuario.class, "usuario", "Usuario de teste");

		Refeicao ref = new Refeicao();
		ref.setNome("outra refeicao de teste axy");
		
		Alimento ali = new Alimento();
		ali.setNome("outro alimento de teste xyz");
		
		ref.addAlimento(ali);
		
		if(user.getListRefeicao() == null)
			user.setListRefeicao(new ArrayList<>());
		
		user.getListRefeicao().add(ref);
		
		HandlerObject.getInstance().update(Usuario.class, user);
		
		Connection.getInstance().closeConnection();
	}
	
	private void read() {
		Usuario user = HandlerObject.getInstance().read(Usuario.class, "usuario", "Usuario de teste");
		
		for(Refeicao ref: user.getListRefeicao())
			for(Alimento ali: ref.getListAlimento())
				System.out.println("Refeicao: "+ref.getNome()+" com alimento: "+ali.getNome());
	}
	
	private void create() {
		Usuario user = new Usuario();
		user.setNome("Nome de teste");
		user.setUsuario("Usuario de teste");
		
		Refeicao ref = new Refeicao();
		ref.setNome("refeicao de teste");
		
		Alimento ali = new Alimento();
		ali.setNome("alimento de teste");
		
		ArrayList<Alimento> listali = new ArrayList<>();
		listali.add(ali);
		
		ref.setListAlimento(listali);
		
		ArrayList<Refeicao> listref = new ArrayList<>();
		listref.add(ref);
		
		user.setListRefeicao(listref);
		HandlerObject.getInstance().create(user);
	}

}
