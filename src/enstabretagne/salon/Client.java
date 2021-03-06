package enstabretagne.salon;

import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.SimuEngine;

public class Client extends EntiteSimulee{

	String nom;
	
	public Client(SimuEngine engine, String nom) {
		super(engine);
		this.nom = nom;
	}

	@Override
	public void Init() {
		Post(new Coupure(Now().add(LogicalDuration.ofMinutes(15)), nom));
	}

	@Override
	public void activate() {
		
	}
	
	@Override
	public String toString() {
		return this.nom;
	}

}
