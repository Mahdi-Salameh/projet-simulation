package enstabretagne.salon;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.Scenario;
import enstabretagne.engine.SimuEngine;

public class ScenarioSalon extends Scenario{
	int nbCoiffeur;

	public ScenarioSalon(SimuEngine engine, String name, int graine, LogicalDateTime debut, LogicalDateTime fin) {
		super(engine, name, graine, debut, fin);
		this.nbCoiffeur = nbCoiffeur;
	}

	@Override
	public void creerEntiteSimulees() {
		
	}

	@Override
	public void Init() {
		
	}

	@Override
	public void activate() {
		
	}

}
