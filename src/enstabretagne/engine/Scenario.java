package enstabretagne.engine;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.simulation.basics.ScenarioId;

public abstract class Scenario extends EntiteSimulee{

	int graine;
	public int getGraine() {
		return graine;
	}
	public Scenario(SimuEngine engine, String name, int graine, LogicalDateTime debut, LogicalDateTime fin) {
		super(engine);
		id = new ScenarioId(name, graine);
		this.graine = graine;
	}
	
	
	public void setGraine(int graine) {
		id.setRepliqueNumber(graine);
		this.graine = graine;
	}

	ScenarioId id;
	ScenarioId getId() {
		return id;
	}
	
	public abstract void creerEntiteSimulees();
	
	

}
