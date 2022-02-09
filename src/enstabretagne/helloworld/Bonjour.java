package enstabretagne.helloworld;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.SimEvent;

public class Bonjour extends SimEvent {

	private String nom;
	
	public Bonjour(LogicalDateTime d,String nom) {
		super(d);
		this.nom = nom;
	}
	
	
	public void process() {
		Logger.Detail(this.entitePorteuseEvenement, "bonjour.Process", "Bonjour de la part de "+nom + " à " +getDateOccurence());
		Logger.Detail(this.entitePorteuseEvenement, "Entites", "" + this.entitePorteuseEvenement.getEntites().stream().filter(e->e instanceof EtudiantSimple).toList());
		this.rescheduleAt(getDateOccurence().add(LogicalDuration.ofMinutes(5)));
		entitePorteuseEvenement.Post(this);
	}

}
