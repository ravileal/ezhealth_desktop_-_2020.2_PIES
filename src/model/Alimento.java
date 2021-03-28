package model;

public class Alimento extends AbstractAlimentacao {

	protected int quantidade;

	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * 
	 * @param quantidade
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}