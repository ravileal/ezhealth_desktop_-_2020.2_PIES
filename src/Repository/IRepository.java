package Repository;

public interface IRepository<T> {

	/**
	 * 
	 * @param obj
	 */
	boolean create(T obj);

	/**
	 * 
	 * @param id
	 */
	ArrayLisy<T> read(String id);

	/**
	 * 
	 * @param obj
	 */
	boolean update(T obj);

	/**
	 * 
	 * @param id
	 */
	boolean delete(String id);

}