package enstabretagne.salon;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.SimEvent;


public class Coupure extends SimEvent{

	String nom;
	
	public Coupure(LogicalDateTime d, String nom) {
		super(d);
		this.nom = nom;
	}

	@Override
	public void process() {
		Logger.Detail(this.entitePorteuseEvenement, "bonjour.Process", nom + " en train de couper les cheveux " + " à " +getDateOccurence());
		Logger.Detail(this.entitePorteuseEvenement, "Entites", "" + this.entitePorteuseEvenement.getEntites().stream().filter(e->e instanceof Client).toList());	
		this.rescheduleAt(getDateOccurence().add(LogicalDuration.ofMinutes(19)));
		entitePorteuseEvenement.Post(this);
	}

}
