package Repository;

public class RepositorioExercicio implements IRepository {

	private StrategyExercicio strategy;

	/**
	 * 
	 * @param strategy
	 */
	public RepositorioExercicio(Repository.StrategyExercicio strategy) {
		// TODO - implement RepositorioExercicio.RepositorioExercicio
		throw new UnsupportedOperationException();
	}

	public StrategyExercicio getStrategy() {
		return this.strategy;
	}

	/**
	 * 
	 * @param strategy
	 */
	public void setStrategy(StrategyExercicio strategy) {
		this.strategy = strategy;
	}

}