package eu.muses.sim.corporate.policy.rule;

import java.util.Date;

import eu.muses.sim.riskman.RiskCommunication;

public class BeforeTimeRule extends Rule {
	 
	private Date beforeTimeDate;

	public BeforeTimeRule(Date beforeTimeDate) {
		super();
		this.beforeTimeDate = beforeTimeDate;
	}
	
	@Override
	public boolean isValidated() {
		boolean validated = false;
		if (beforeTimeDate.before(new Date(System.currentTimeMillis()))) {
			validated = true;
		}
		return validated;
	}

	@Override
	public RiskCommunication getValidatedRiskCommunication() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RiskCommunication getNotValidatedRiskCommunication() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
