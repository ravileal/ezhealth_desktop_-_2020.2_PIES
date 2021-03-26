package Model;

import java.util.Date;

public class Exercicio extends Model {

	private int calorias;
	private String duracao;
	private Date data;

	public int getCalorias() {
		return this.calorias;
	}

	/**
	 * 
	 * @param calorias
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	public String getDuracao() {
		return this.duracao;
	}

	/**
	 * 
	 * @param duracao
	 */
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	@Override
	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	

}