package enstabretagne.engine;

import java.util.List;

import enstabretagne.base.time.LogicalDateTime;

public abstract class EntiteSimulee {
	private SimuEngine engine;

	public EntiteSimulee(SimuEngine engine) {
		this.engine=engine;
		engine.mesEntitesSimulees.add(this);
	}
	
	public void Post(SimEvent ev) {
		engine.Post(ev);
		ev.entitePorteuseEvenement = this;
	}
	
	public LogicalDateTime Now() {
		return engine.getCurrentDate();
	}
	
	public List<EntiteSimulee> getEntites() {
		return engine.mesEntitesSimulees;
	} 
	
	public SimuEngine getEngine() {
		return engine;
	}

	public abstract void Init();

	public abstract void activate();
}
