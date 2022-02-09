package enstabretagne.engine;

import java.util.ArrayList;
import java.util.List;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.simulation.basics.IScenarioIdProvider;
import enstabretagne.simulation.basics.ISimulationDateProvider;
import enstabretagne.simulation.basics.ScenarioId;
import enstabretagne.simulation.basics.SortedList;

public class SimuEngine implements ISimulationDateProvider,IScenarioIdProvider{
	
	private SortedList<SimEvent> echeancier;
	private LogicalDateTime start;
	private LogicalDateTime end;
	private LogicalDateTime currentDate;
	protected List<EntiteSimulee> mesEntitesSimulees;
	private Scenario currentScenario; 
	

	public SimuEngine() {
		echeancier = new SortedList<>();
		mesEntitesSimulees = new ArrayList<>();
		Logger.setDateProvider(this);
	}
	
	
	protected void Post(SimEvent ev) {
		echeancier.add(ev);
	}
	
	public void simulate()
	{
		while(hasANextEvent())
		{
			SimEvent ev = echeancier.first();
			echeancier.remove(ev);
			currentDate = ev.getDateOccurence();
			ev.process();
		}
	}
	
	private boolean hasANextEvent() {
		for(SimEvent e:echeancier)
		{
			if(e.getDateOccurence().compareTo(end)<=0)
				return true;
		}
		return false;
	}
	
	public List<EntiteSimulee> getEntites() {
		return mesEntitesSimulees;
	}

	public void setCurrentScenario(Scenario sc) {
		this.currentScenario = sc;
		
		if(currentScenario != null) {
			this.start= currentScenario.debut;
			currentDate = this.start;
			this.end = currentScenario.fin;
		}
	}

	public void terminate() {
		this.echeancier.clear();
		this.mesEntitesSimulees.clear();
		this.start = null;
		this.end = null;
		this.currentDate = null;
		this.currentScenario = null;
		
	}

	public void activateSimulation() {
			
			for(EntiteSimulee e:mesEntitesSimulees)
			{
				e.Init();
			}	
				
	}

	public LogicalDateTime SimulationDate() {

		return currentDate;
	}


	@Override
	public ScenarioId getScenarioId() {
		return currentScenario.getId();
	}
	
}
