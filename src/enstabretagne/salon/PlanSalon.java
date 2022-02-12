package enstabretagne.salon;

import java.util.LinkedList;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.Plan;
import enstabretagne.engine.Scenario;
import enstabretagne.engine.SimuEngine;


public class PlanSalon extends Plan{

	LogicalDateTime debut;
	LogicalDateTime fin;
	LinkedList<ScenarioSalon> salonSC;

	public PlanSalon(SimuEngine engine, int nbReplique, LogicalDateTime debut, LogicalDateTime fin) {
		super(engine, nbReplique);
		salonSC = new LinkedList<>();
		this.debut = debut;
		this.fin = fin;
	}

	@Override
	public void initScenarii() {
		/*for(int i=0;i<getNbReplique();i++)
			enstaSC.add(new ScenarioENSTA(getEngine(), "Scenario 1 Etudiant", i, debut, fin, 1));
		for(int i = 0; i<getNbReplique();i++)
			salonSC.add(new ScenarioENSTA(getEngine(), "Scenario 3 Etudiants", i, debut, fin, 3));
		*/
	}

	@Override
	public boolean hasNextScenario() {
		return salonSC.size()>0;
	}

	@Override
	public Scenario nextScenario() {
		Scenario sc = salonSC.pop();
		engine.setCurrentScenario(sc);
		return sc;
	}
	

}
