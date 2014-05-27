package eu.muses.sim.context;

import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.vulnerability.Vulnerability;


public interface Contextable {

	public Probability isUnderAttack();
	
	public Vulnerability[] getVulnerabilities();
	
	
}
