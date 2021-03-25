package Model;

import java.util.*;

import Validation.DadosVaziosException;

public class Refeicao extends AbstractAlimentacao {

	private Date data;
	private String tipo;
	private ArrayList<Alimento> listAlimento;

	public Refeicao(){
		listAlimento = new ArrayList<Alimento>();
	}
	
	public Date getData() {
		return this.data;
	}

	/**
	 * 
	 * @param data
	 */
	public void setData(Date data) {
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

	public ArrayList<Alimento> getListAlimento() {
		return this.listAlimento;
	}

	/**
	 * 
	 * @param listAlimento
	 */
	public void setListAlimento(ArrayList<Alimento> listAlimento) {
		this.listAlimento = listAlimento;
	}

	/**
	 * 
	 * @param alimento
	 */
	public void delAlimento(Alimento alimento) {
		this.listAlimento.remove(alimento);
	}

	/**
	 * 
	 * @param alimento
	 */
	public void addAlimento(Alimento alimento) {
		this.listAlimento.add(alimento);
	}

	/**
	 * 
	 * @param alimento
	 */
	public void setAlimento(Alimento alimento) throws DadosVaziosException, NullPointerException {
		if(alimento == null)
			throw new NullPointerException("Alimento nulo");
		else if(alimento.getNome().equals(""))
			throw new DadosVaziosException("Alimento com nome vazio");
		
		int i = 0;
		boolean find = false;
		for(; i<listAlimento.size(); i++){
			if(listAlimento.get(i).getNome().equals(alimento.getNome())) {
				find = true;
				this.listAlimento.set(i, alimento);
				break;
			}
		}
		if(!find) 
			throw new NullPointerException();
	}

}
