package model;

import java.util.Date;

public class Exercicio extends Model implements Cloneable {

	private int calorias;
	private Integer duracao;
	private Date data;
	private Usuario usuario;

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

	public Integer getDuracao() {
		return this.duracao;
	}

	/**
	 * 
	 * @param duracao
	 */
	public void setDuracao(Integer duracao) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Exercicio clone() throws CloneNotSupportedException {
        return (Exercicio) super.clone();
    }

}