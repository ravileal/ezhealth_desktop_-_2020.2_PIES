package model;

import java.util.*;

import validation.DadosVaziosException;

public class Refeicao extends AbstractAlimentacao {

	private Date data;
	private boolean isDiaria;
	private List<Alimento> listAlimento;
	private Usuario usuario;

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


	public boolean getIsDiaria() {
		return isDiaria;
	}

	public void setIsDiaria(boolean isDiaria) {
		this.isDiaria = isDiaria;
	}

	public List<Alimento> getListAlimento() {
		return this.listAlimento;
	}

	/**
	 * 
	 * @param listAlimento
	 */
	public void setListAlimento(List<Alimento> listAlimento) {
		this.listAlimento = listAlimento;
	}

	/**
	 * 
	 * @param alimento
	 * @return 
	 */
	public boolean delAlimento(Alimento alimento) {
		setCalorias( getCalorias() - alimento.getCalorias() );
		setProteina( getProteina() - alimento.getProteina() );
		setCarboidrato( getCarboidrato() - alimento.getCarboidrato() );
		setGordura( getGordura() - alimento.getGordura() );
		setTaxaAcucar( getTaxaAcucar() - alimento.getTaxaAcucar() );
		return this.listAlimento.remove(alimento);
	}

	/**
	 * 
	 * @param alimento
	 */
	public void addAlimento(Alimento alimento) {
		if(this.listAlimento==null) this.listAlimento = new ArrayList<Alimento>();
		this.listAlimento.add(alimento);
		setCalorias( getCalorias() + alimento.getCalorias() );
		setProteina( getProteina() + alimento.getProteina() );
		setCarboidrato( getCarboidrato() + alimento.getCarboidrato() );
		setGordura( getGordura() + alimento.getGordura() );
		setTaxaAcucar( getTaxaAcucar() + alimento.getTaxaAcucar() );
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
			if(listAlimento.get(i).getId() == alimento.getId()) {
				find = true;
				this.listAlimento.set(i, alimento);
				break;
			}
		}
		if(!find) 
			throw new NullPointerException();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
