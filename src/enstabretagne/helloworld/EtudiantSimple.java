package enstabretagne.helloworld;

import enstabretagne.base.time.LogicalDuration;
import enstabretagne.engine.EntiteSimulee;
import enstabretagne.engine.SimuEngine;

public class EtudiantSimple extends EntiteSimulee{
	private String nom;

	public EtudiantSimple(SimuEngine engine,String nom) {
		super(engine);
		this.nom = nom;
	}
	
	@Override
	public void Init() {
		Post(new Bonjour(Now().add(LogicalDuration.ofMinutes(15)), nom));
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return this.nom;
	}
}
