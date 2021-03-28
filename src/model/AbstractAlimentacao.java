package model;

public abstract class AbstractAlimentacao extends Model{

	protected int calorias; 
	protected int proteina;
	protected int carboidrato;
	protected int gordura;
	protected int taxaAcucar;
	protected boolean glutem;
	protected boolean lactose;
	protected boolean favorito;

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

	public int getProteina() {
		return this.proteina;
	}

	/**
	 * 
	 * @param proteina
	 */
	public void setProteina(int proteina) {
		this.proteina = proteina;
	}

	public int getCarboidrato() {
		return this.carboidrato;
	}

	/**
	 * 
	 * @param carboidrato
	 */
	public void setCarboidrato(int carboidrato) {
		this.carboidrato = carboidrato;
	}

	public int getGordura() {
		return this.gordura;
	}

	/**
	 * 
	 * @param gordura
	 */
	public void setGordura(int gordura) {
		this.gordura = gordura;
	}

	public int getTaxaAcucar() {
		return this.taxaAcucar;
	}

	/**
	 * 
	 * @param taxaAcucar
	 */
	public void setTaxaAcucar(int taxaAcucar) {
		this.taxaAcucar = taxaAcucar;
	}

	public boolean getGlutem() {
		return this.glutem;
	}

	/**
	 * 
	 * @param glutem
	 */
	public void setGlutem(boolean glutem) {
		this.glutem = glutem;
	}

	public boolean getLactose() {
		return this.lactose;
	}

	/**
	 * 
	 * @param lactose
	 */
	public void setLactose(boolean lactose) {
		this.lactose = lactose;
	}

	public boolean getFavorito() {
		return this.favorito;
	}

	/**
	 * 
	 * @param favorito
	 */
	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

}