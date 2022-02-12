package enstabretagne.engine;

public abstract class Plan {
	
	private int nbReplique;
	protected SimuEngine engine;
	private int currentRepliqueNumber;
	
	public int getNbReplique() {
		return nbReplique;
	}

	public SimuEngine getEngine() {
		return engine;
	}

	public int getCurrentRepliqueNumber() {
		return currentRepliqueNumber;
	}

	public Plan(SimuEngine engine, int nbReplique) {
		this.nbReplique = nbReplique;
		this.engine = engine;
	}
	
	public abstract void initScenarii();
	public abstract boolean hasNextScenario();
	public abstract Scenario nextScenario();
}
