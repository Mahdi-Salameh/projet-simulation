package enstabretagne.salon;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.SimuEngine;


public class Salon {
	
	public static void main(String[] args) {
		SimuEngine engine = new SimuEngine();

		LogicalDateTime start = new LogicalDateTime("18/01/2022 10:00");
		LogicalDateTime end = new LogicalDateTime("18/01/2022 20:00");
		
		PlanSalon plan = new PlanSalon(engine, 1, start, end);
		plan.initScenarii();
		
		while(plan.hasNextScenario())
		{
			plan.nextScenario().creerEntiteSimulees();
			engine.activateSimulation();
			engine.simulate();
			engine.terminate();
		}
		
		Logger.Terminate();
	}

}
