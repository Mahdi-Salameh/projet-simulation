package enstabretagne.helloworld;

import enstabretagne.base.logger.Logger;
import enstabretagne.base.time.LogicalDateTime;
import enstabretagne.engine.SimuEngine;

public class ENSTA {
	public static void main(String[] args) {
		SimuEngine engine = new SimuEngine();

		LogicalDateTime start = new LogicalDateTime("04/12/2019 14:00");
		LogicalDateTime end = new LogicalDateTime("04/12/2019 15:00");

		PlanHelloWorld plan = new PlanHelloWorld(engine, 3, start, end);
		plan.initScenarii();
		
		while(plan.hasNextScenario())
		{
			plan.nextScenario().creerEntiteSimulees();
			engine.activateSimulation(start,end);
			engine.simulate();
			engine.terminate();
		}
		
		Logger.Terminate();
	}
}
