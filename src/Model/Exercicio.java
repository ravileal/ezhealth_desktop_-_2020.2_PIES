package Model;

public class Exercicio {

	private float calorias;
	private String duracao;
	private String nome;
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

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

}