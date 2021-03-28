package model;

import java.util.*;

import model.to.ToRefeicao;
import validation.DadosVaziosException;

public class Refeicao extends AbstractAlimentacao {

	protected String data;
	protected String tipo;
	
	public String getData() {
		return this.data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return this.tipo;
	}

	/**
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

//	public ArrayList<Alimento> getListAlimento() {
//		return this.listAlimento;
//	}
//
//	/**
//	 * 
//	 * @param listAlimento
//	 */
//	public void setListAlimento(ArrayList<Alimento> listAlimento) {
//		this.listAlimento = listAlimento;
//	}
//
//	/**
//	 * 
//	 * @param alimento
//	 */
//	public void delAlimento(Alimento alimento) {
//		setCalorias(getCalorias()-alimento.getCalorias());
//		this.listAlimento.remove(alimento);
//	}
//
//	/**
//	 * 
//	 * @param alimento
//	 */
//	public void addAlimento(Alimento alimento) {
//		if(this.listAlimento==null) this.listAlimento = new ArrayList<Alimento>();
//		this.listAlimento.add(alimento);
//		setCalorias(getCalorias()+alimento.getCalorias());
//	}
//
//	/**
//	 * 
//	 * @param alimento
//	 */
//	public void setAlimento(Alimento alimento) throws DadosVaziosException, NullPointerException {
//		if(alimento == null)
//			throw new NullPointerException("Alimento nulo");
//		else if(alimento.getNome().equals(""))
//			throw new DadosVaziosException("Alimento com nome vazio");
//		
//		int i = 0;
//		boolean find = false;
//		for(; i<listAlimento.size(); i++){
//			if(listAlimento.get(i).getNome().equals(alimento.getNome())) {
//				find = true;
//				this.listAlimento.set(i, alimento);
//				break;
//			}
//		}
//		if(!find) 
//			throw new NullPointerException();
//	}
	
	
	public ToRefeicao toToRefeicao() {
		ToRefeicao refeicao = new ToRefeicao();
		
		refeicao.setId(id);
		refeicao.setNome(nome);
		refeicao.setData(data);
		refeicao.setTipo(tipo);
		refeicao.setListAlimento(new ArrayList<Alimento>());
		refeicao.setCalorias(calorias); 
		refeicao.setProteina(proteina);
		refeicao.setCarboidrato(carboidrato);
		refeicao.setGordura(gordura);
		refeicao.setTaxaAcucar(taxaAcucar);
		refeicao.setGlutem(glutem);
		refeicao.setLactose(lactose);
		refeicao.setFavorito(favorito);
		
		return refeicao;
	}

}
