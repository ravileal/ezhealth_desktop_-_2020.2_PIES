package Controller;

public interface IController<T> {

	/**
	 * 
	 * @param obj
	 */
	boolean adicionar(T obj);

	/**
	 * 
	 * @param id
	 */
	ArrayList<T> buscar(String id);

	/**
	 * 
	 * @param obj
	 */
	boolean editar(T obj);

	/**
	 * 
	 * @param id
	 */
	boolean remover(String id);

	/**
	 * 
	 * @param obj
	 */
	boolean validarCampos(T obj);

}