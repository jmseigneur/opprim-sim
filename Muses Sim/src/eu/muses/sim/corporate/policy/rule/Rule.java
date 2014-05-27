package eu.muses.sim.corporate.policy.rule;

import eu.muses.sim.riskman.RiskCommunication;
import eu.muses.sim.riskman.RiskTreatment;

public abstract class Rule {
	
	public abstract boolean isValidated();
	
	public abstract RiskCommunication getValidatedRiskCommunication();
	
	public abstract RiskCommunication getNotValidatedRiskCommunication();

}
