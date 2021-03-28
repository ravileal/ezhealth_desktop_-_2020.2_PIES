package controller;

import java.util.ArrayList;

import model.Alimento;
import model.Refeicao;
import model.RefeicaoAlimentoUsuario;
import model.dao.DAORefeicaoAlimentoUsuario;
import model.dao.connection.HandlerObject;
import model.to.ToRefeicao;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

public class ControllerRefeicaoAlimentoUsuario {
	
	private static DAORefeicaoAlimentoUsuario dao; 
	private static HandlerObject handlerObject;
	
	public ControllerRefeicaoAlimentoUsuario() {
		dao = new DAORefeicaoAlimentoUsuario();
		handlerObject = HandlerObject.getInstance();
	}
	
	
	public String adicionar(Alimento alimento, Refeicao refeicao) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {

		String idRefeicao = refeicao.getId();		
		String idAlimento = new ControllerAlimento().adicionar(alimento);
		String idUsuario = ControllerUsuario.getUsuarioLogado().getId();
		
		RefeicaoAlimentoUsuario ref = new RefeicaoAlimentoUsuario();
		ref.setIdAlimento(idAlimento);
		ref.setIdRefeicao(idRefeicao);
		ref.setIdUsuario(idUsuario);
		
		return dao.create(ref);
	}
	
	public ArrayList<RefeicaoAlimentoUsuario> buscarTodos() {
		ArrayList<RefeicaoAlimentoUsuario> list = new ArrayList<RefeicaoAlimentoUsuario>();
		
		for(RefeicaoAlimentoUsuario ref: dao.readAll(RefeicaoAlimentoUsuario.class))
			list.add(ref);
	 
		return list;
	}
	
	public ArrayList<RefeicaoAlimentoUsuario> buscarTodosPorIdUsuario(String id) {
		ArrayList<RefeicaoAlimentoUsuario> list = new ArrayList<RefeicaoAlimentoUsuario>();
		
		for(RefeicaoAlimentoUsuario ref: dao.readIdUsuarioAll(RefeicaoAlimentoUsuario.class, id))
			list.add(ref);
	 
		return list;
	}
	
	public ArrayList<RefeicaoAlimentoUsuario> buscarTodosPorIdRefeicao(String id) {
		ArrayList<RefeicaoAlimentoUsuario> list = new ArrayList<RefeicaoAlimentoUsuario>();
		
		for(RefeicaoAlimentoUsuario ref: dao.readIdRefeicaoAll(RefeicaoAlimentoUsuario.class, id))
			list.add(ref);
	 
		return list;
	}
	
	public ArrayList<Alimento> buscarTodosAlimentosPorIdRefeicao(String id){
		ArrayList<Alimento> list = new ArrayList<>();
		
		for(RefeicaoAlimentoUsuario ref: buscarTodosPorIdRefeicao(id))
			list.add(handlerObject.read(Alimento.class, ref.getIdAlimento()));
		
		return list;
	}
	
	public void remover(RefeicaoAlimentoUsuario ref) {
		dao.delete(ref);
	}

}
