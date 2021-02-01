package Controller;

public interface IAlimentacao<T> {

	/**
	 * 
	 * @param glutem
	 * @param lactose
	 * @param taxaAcucar
	 */
	ArrayList<T> buscar(boolean glutem, boolean lactose, int taxaAcucar);

}