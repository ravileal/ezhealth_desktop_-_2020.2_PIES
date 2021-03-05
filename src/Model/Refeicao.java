package Model;

import java.util.*;

public class Refeicao extends AbstractAlimentacao {

	private Date data;
	private String tipo;
	private Collection<Alimento> listAlimento;

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
		// TODO - implement Refeicao.getListAlimento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listAlimento
	 */
	public void setListAlimento(ArrayList<Alimento> listAlimento) {
		// TODO - implement Refeicao.setListAlimento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param alimento
	 */
	public void delAlimento(Alimento alimento) {
		// TODO - implement Refeicao.delAlimento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param alimento
	 */
	public void addAlimento(Alimento alimento) {
		// TODO - implement Refeicao.addAlimento
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param alimento
	 */
	public void setAlimento(Alimento alimento) {
		// TODO - implement Refeicao.setAlimento
		throw new UnsupportedOperationException();
	}

}