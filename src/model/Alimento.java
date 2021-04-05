package model;

public class Alimento extends AbstractAlimentacao implements Cloneable {

	private int quantidade;
	private Refeicao refeicao;

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

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
	
	public Alimento clone() throws CloneNotSupportedException {
        return (Alimento) super.clone();
    }

}