package controller;

import model.*;
import model.dao.connection.HandlerObject;
import repository.RepositorioRefeicao;
import repository.RepositorioRefeicaoRealizada;
import util.*;
import validation.DadosVaziosException;
import validation.OperacaoNaoConcluidaRepositorioExeception;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControllerRefeicao implements CRUD<Refeicao>, IAlimentacao<Refeicao> {

	private RepositorioRefeicao rep;
	private static HandlerObject handlerObject = HandlerObject.getInstance();
	private RepositorioRefeicaoRealizada repRealizada;
	private boolean refeicaoRealizada;
	
	public ControllerRefeicao(boolean refeicaoRealizada) {
		Popular.getInstance();
		this.rep = new RepositorioRefeicao();
		this.repRealizada = new RepositorioRefeicaoRealizada();
		this.refeicaoRealizada = refeicaoRealizada;
	}
	
	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	
	@Override
	public boolean adicionar(Refeicao obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Impossível adicionar! Objeto Refeicao null");
		else if(obj.getNome() == null)
			throw new DadosVaziosException("Impossível adicionar! Nome vazio");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível adicionar! Nome vazio");
		else if(!handlerObject.create(obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível adicionar! Erro ao tentar adicionar a refeicao '"+obj.getNome()+"' ao repositorio");
		else 
			return true;
	}
	

	@Override
	public ArrayList<Refeicao> buscarTodos() throws DadosVaziosException, NullPointerException {
		ArrayList<Refeicao> list = (ArrayList<Refeicao>) handlerObject.readAll(Refeicao.class);
		
		if(list == null)
			throw new NullPointerException("Não foi possível encontrar refeicao a partir do nome");
		else 
			return list;
	}

	@Override
	public Refeicao buscar(String nome) throws DadosVaziosException, NullPointerException {
		if(nome != null && nome.equals(""))
			throw new DadosVaziosException("Impossível buscar! Nome vazio");
		
		Refeicao refeicao = handlerObject.read(Refeicao.class, nome);
		
		if(refeicao == null)
			throw new NullPointerException("Não foi possível encontrar refeicao a partir do nome");
		else 
			return refeicao;
	}

	@Override
	public boolean editar(String nome, Refeicao obj) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception, NullPointerException {
		if(obj == null)
			throw new NullPointerException("Impossível editar! Objeto Refeicao null");
		else if(obj.getNome().equals(""))
			throw new DadosVaziosException("Impossível editar! Nome vazio");
		else if(!handlerObject.update(Refeicao.class, obj))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível editar! Erro ao tentar editar o refeicao '"+nome+"' no repositorio");
		else 
			return true;
	}

	@Override
	public boolean remover(String nome) throws DadosVaziosException, OperacaoNaoConcluidaRepositorioExeception {
		if(nome.equals(""))
			throw new DadosVaziosException("Impossível excluir! Nome vazio");
		else if(handlerObject.create(buscar(nome)))
			throw new OperacaoNaoConcluidaRepositorioExeception("Impossível excluir! Erro ao tentar excluir o refeicao '"+nome+"' no repositorio");
		else 
			return true;
	}
	
	/* -----------------------------
	 * 		Métodos do dominio
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

	@Override
	public ArrayList<Refeicao> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
		// TODO Auto-generated method stub
		return null;
	}

}