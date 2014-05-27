package eu.muses.sim.corporate.policy.rule;

import java.util.Date;

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
	

}
