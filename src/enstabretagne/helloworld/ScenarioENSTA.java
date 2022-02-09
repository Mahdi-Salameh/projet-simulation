package enstabretagne.helloworld;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.Scenario;
import enstabretagne.engine.SimEvent;
import enstabretagne.engine.SimuEngine;

public class ScenarioENSTA extends Scenario{
	
	public ScenarioENSTA(SimuEngine engine, String name, int graine, LogicalDateTime debut, LogicalDateTime fin, int nbEtudiants) {
		super(engine, name, graine, debut, fin);
		this.nbEtudiants = nbEtudiants;
	}

	int nbEtudiants;

	@Override
	public void creerEntiteSimulees() {
		for(int i=0;i<getNbEtudiants();i++) {
			new EtudiantSimple(getEngine(), "Et"+i);
		}
		
		Post(new CreerEtudiant(getEngine().SimulationDate().add(LogicalDuration.ofMinutes(8)), "Salameh"));
	}
	
	@Override
	public void activate() {
		for(EntiteSimulee e: getEntites()) {
			if(!(e instanceof Scenario))
				e.activate();
		}
	}
	

	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}

	public int getNbEtudiants() {
		return nbEtudiants;
	}
	private static class CreerEtudiant extends SimEvent{

		String nom;
		public CreerEtudiant(LogicalDateTime d, String nom) {
			super(d);
			this.nom = nom;
		}
		@Override
		public void process() {
			EtudiantSimple es = new EtudiantSimple(entitePorteuseEvenement.getEngine(), nom);
			es.activate();
			
		}
		
	}



}
