package Repository;

import Model.*;

public class RepositorioRefeicao implements IRepository {

	private StrategyRefeicao<Refeicao> strategy;

	public Repository.StrategyRefeicao<Refeicao> getStrategy() {
		return this.strategy;
	}

	/**
	 * 
	 * @param strategy
	 */
	public void setStrategy(Repository.StrategyRefeicao<Refeicao> strategy) {
		this.strategy = strategy;
	}

	/**
	 * 
	 * @param strategy
	 */
	public RepositorioRefeicao(StrategyRefeicao strategy) {
		// TODO - implement RepositorioRefeicao.RepositorioRefeicao
		throw new UnsupportedOperationException();
	}

}