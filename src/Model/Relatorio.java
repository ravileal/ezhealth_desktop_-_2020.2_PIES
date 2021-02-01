package Model;

import java.util.*;

public class Relatorio {

	private int caloriasPerdidas;
	private Date dataIni;
	private Date dataFim;
	private Refeicao refeicao;
	private Collection<Exercicio> listExercicio;

	public int getCaloriasPerdidas() {
		return this.caloriasPerdidas;
	}

	/**
	 * 
	 * @param caloriasPerdidas
	 */
	public void setCaloriasPerdidas(int caloriasPerdidas) {
		this.caloriasPerdidas = caloriasPerdidas;
	}

	public Date getDataIni() {
		return this.dataIni;
	}

	/**
	 * 
	 * @param dataIni
	 */
	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	/**
	 * 
	 * @param dataFim
	 */
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Refeicao getRefeicao() {
		return this.refeicao;
	}

	/**
	 * 
	 * @param refeicao
	 */
	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}

	public ArrayList<Exercicio> getListExercicio() {
		// TODO - implement Relatorio.getListExercicio
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listExercicio
	 */
	public void setListExercicio(ArrayList<Exercicio> listExercicio) {
		// TODO - implement Relatorio.setListExercicio
		throw new UnsupportedOperationException();
	}

}