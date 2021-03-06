package Controller;

import Util.*;

import java.util.ArrayList;
import java.util.Date;

import Model.*;
import Repository.RepositorioRefeicao;
import Repository.RepositorioRefeicaoRealizada;

public class ControllerRefeicao implements CRUD<Refeicao>, IAlimentacao<Refeicao> {

	private RepositorioRefeicao rep;
	private RepositorioRefeicaoRealizada repRealizada;
	private boolean refeicaoRealizada;
	
	public ControllerRefeicao(boolean refeicaoRealizada) {
		this.rep = new RepositorioRefeicao();
		this.repRealizada = new RepositorioRefeicaoRealizada();
		this.refeicaoRealizada = refeicaoRealizada;
	}
	
	/* -----------------------------
	 * 		Métodos do CRUD
	 * -----------------------------*/
	
	@Override
	public boolean adicionar(Refeicao obj) {
		return (obj.getNome().equals(""))? false : 
		(refeicaoRealizada)? repRealizada.adicionar(obj) : rep.adicionar(obj);
	}

	@Override
	public ArrayList<Refeicao> buscar(String nome) {
		return (nome.equals(""))? null: 
		(refeicaoRealizada)? repRealizada.buscar(nome) : rep.buscar(nome);
	}

	@Override
	public boolean editar(String nome, Refeicao obj) {
		return (nome.equals(""))? false: 
		(refeicaoRealizada)? repRealizada.editar(nome, obj) : rep.editar(nome, obj);
	}

	@Override
	public boolean remover(String nome) {
		return (nome.equals(""))? false: 
		(refeicaoRealizada)? repRealizada.remover(nome) : rep.remover(nome);
	}
	
	/* -----------------------------
	 * 		Métodos do dominio
	 * -----------------------------*/
	
	/**
	 * 
	 * @param dataIni
	 * @param dataFim
	 */
	public Refeicao buscar(Date dataIni, Date dataFim) {
		// TODO - implement ControllerRefeicao.buscar
		throw new UnsupportedOperationException();
	}

	@Override
	public ArrayList<Refeicao> buscar(boolean glutem, boolean lactose, int taxaAcucar) {
		// TODO Auto-generated method stub
		return null;
	}

}