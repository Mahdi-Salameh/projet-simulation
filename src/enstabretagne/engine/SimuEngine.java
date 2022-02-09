package enstabretagne.engine;

import java.util.ArrayList;
import java.util.List;

import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.simulation.basics.SortedList;

public class SimuEngine {
	
	private SortedList<SimEvent> echeancier;
	private LogicalDateTime start;
	private LogicalDateTime end;
	private LogicalDateTime currentDate;
	protected List<EntiteSimulee> mesEntitesSimulees; 
	
	protected LogicalDateTime getCurrentDate()
	{
		return currentDate;
	}
	
	public SimuEngine() {
		echeancier = new SortedList<>();
		mesEntitesSimulees = new ArrayList<>();
	}
	
	public void initSimulation(LogicalDateTime start, LogicalDateTime end) {
		this.start=start;
		currentDate = this.start;
		this.end = end;
		
		for(EntiteSimulee e:mesEntitesSimulees)
		{
			e.Init();
		}
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
		// TODO Auto-generated method stub
		
	}

	public void terminate() {
		// TODO Auto-generated method stub
		
	}

	public void activateSimulation(LogicalDateTime start2, LogicalDateTime end2) {
		// TODO Auto-generated method stub
		
	}

	public LogicalDateTime SimulationDate() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
