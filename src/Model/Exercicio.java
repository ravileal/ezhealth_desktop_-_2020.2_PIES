package Model;

import java.util.Date;

public class Exercicio extends Model{

	private float calorias;
	private String duracao;
	private Date data;

	public float getCalorias() {
		return this.calorias;
	}

	/**
	 * 
	 * @param calorias
	 */
	public void setCalorias(float calorias) {
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

}