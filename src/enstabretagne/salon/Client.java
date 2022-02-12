package enstabretagne.salon;

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
		
	}

	@Override
	public void activate() {
		
	}
	
	@Override
	public String toString() {
		return this.nom;
	}

}
