package controller;

import model.*;
import model.dao.DAORefeicaoAlimentoUsuario;
import model.dao.connection.HandlerObject;
import model.to.ToRefeicao;
import repository.RepositorioRefeicao;
import repository.RepositorioRefeicaoRealizada;
import util.*;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControllerRefeicao {

	private static HandlerObject handlerObject = HandlerObject.getInstance();
	
	
	/* -----------------------------
	 * 		M�todos do CRUD
	 * -----------------------------*/
	
	
	public String adicionar(Refeicao obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel adicionar! Objeto Refeicao null");
		else if(obj.getNome() == null)
			throw new DadosVaziosException("Imposs�vel adicionar! Nome vazio");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel adicionar! Nome vazio");
		
		return handlerObject.create(obj);
	}
	
	public ArrayList<Refeicao> buscarTodos() throws DadosVaziosException, NullPointerException {
		ArrayList<Refeicao> list = new ArrayList<Refeicao>();
		
		for(Refeicao refeicao: handlerObject.readAll(Refeicao.class))
			list.add(refeicao);
				
		return list;
	}

	
	public Refeicao buscar(String nome) throws DadosVaziosException, NullPointerException {
		if(nome != null && nome.equals(""))
			throw new DadosVaziosException("Imposs�vel buscar! Nome vazio");
		
		Refeicao refeicao = handlerObject.readNome(Refeicao.class, nome);
		
		if(refeicao == null)
			throw new NullPointerException("N�o foi poss�vel encontrar refeicao a partir do nome");
		else 
			return refeicao;
	}


	public boolean editar(Refeicao obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Imposs�vel editar! Objeto Refeicao null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Imposs�vel editar! Nome vazio");
		else if(!handlerObject.update(Refeicao.class, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel editar! Erro ao tentar editar o refeicao '"+obj.getNome()+"' no repositorio");
		else 
			return true;
	}

	public boolean remover(String id) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
//		if(id < 1)
//			throw new DadosVaziosException("Imposs�vel excluir! Refeicao n�o existe");
		
		boolean result = handlerObject.delete(id);
		
		if(!result)
			throw new OperacaoNaoConcluidaRepositorioExeception("Imposs�vel excluir! Erro ao tentar excluir a refeicao no repositorio");
		else 
			return true;
	}
	
	/* -----------------------------
	 * 		M�todos do dominio
	 * -----------------------------*/
	
	/**
	 * 
	 * @param dia
	 */
	public ArrayList<Refeicao> buscarPorData(Date date) {
		ArrayList<Refeicao> list = new ArrayList<Refeicao>();
		try {
			for(Refeicao ref: this.buscarTodos()) {
			  	SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
				String dataBusca = dayFormat.format(date);
				String dataRefeicao = dayFormat.format(ref.getData());
				System.out.println("databusca: "+dataBusca+ "\n datarefeicao "+dataRefeicao);
				if(dataBusca.equals(dataRefeicao))
					list.add(ref);
			}
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosVaziosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return (list.size()==0)? null: list;
	}
	
	public int getCaloriasRefeicoes(Date date) {
		int calorias = 0;
		for(Refeicao ref :buscarPorData(date))
			calorias += ref.getCalorias();
		
		return calorias;
	}

}