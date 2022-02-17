package enstabretagne.salon;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.Scenario;
import enstabretagne.engine.SimEvent;
import enstabretagne.engine.SimuEngine;


public class ScenarioSalon extends Scenario{
	int nbClients;

	public ScenarioSalon(SimuEngine engine, String name, int graine, LogicalDateTime debut, LogicalDateTime fin, int nbClients) {
		super(engine, name, graine, debut, fin);
		this.nbClients = nbClients;
	}

	@Override
	public void creerEntiteSimulees() {
		for(int i=0;i<this.nbClients;i++) {
			new Client(getEngine(), "Client"+i);
		}
		
		Post(new CreerClient(getEngine().SimulationDate().add(LogicalDuration.ofMinutes(8)), "Salameh"));
	}

	@Override
	public void Init() {
		
	}

	@Override
	public void activate() {
		for(EntiteSimulee e: getEntites()) {
			if(!(e instanceof Scenario))
				e.activate();
		}
		
	}

	public int getNbClients() {
		return nbClients;
	}
	
	private static class CreerClient extends SimEvent{

		String nom;
		public CreerClient(LogicalDateTime d, String nom) {
			super(d);
			this.nom = nom;
		}
		@Override
		public void process() {
			Client es = new Client(entitePorteuseEvenement.getEngine(), nom);
			es.activate();
			
		}
		
	}

	
}
