package enstabretagne.engine;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.simulation.basics.ScenarioId;

public abstract class Scenario extends EntiteSimulee{

	int graine;
	LogicalDateTime debut;
	LogicalDateTime fin;
	ScenarioId id;
	
	public Scenario(SimuEngine engine, String name, int graine, LogicalDateTime debut, LogicalDateTime fin) {
		super(engine);
		id = new ScenarioId(name, graine);
		this.graine = graine;
		this.debut = debut;
		this.fin = fin;
	}
	
	public int getGraine() {
		return graine;
	}	
	
	public void setGraine(int graine) {
		id.setRepliqueNumber(graine);
		this.graine = graine;
	}

	ScenarioId getId() {
		return id;
	}
	
	public abstract void creerEntiteSimulees();

}
