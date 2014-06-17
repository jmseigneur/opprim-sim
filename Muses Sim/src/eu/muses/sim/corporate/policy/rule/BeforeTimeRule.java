/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.corporate.policy.rule;

import java.util.Date;

import eu.muses.sim.riskman.RiskCommunication;

/**
 * The Class BeforeTimeRule.
 */
public class BeforeTimeRule extends Rule {

	/** The before time date. */
	private Date beforeTimeDate;

	/**
	 * Instantiates a new before time rule.
	 *
	 * @param beforeTimeDate
	 *            the before time date
	 */
	public BeforeTimeRule(Date beforeTimeDate) {
		super();
		this.beforeTimeDate = beforeTimeDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.muses.sim.corporate.policy.rule.Rule#getNotValidatedRiskCommunication
	 * ()
	 */
	@Override
	public RiskCommunication getNotValidatedRiskCommunication() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * eu.muses.sim.corporate.policy.rule.Rule#getValidatedRiskCommunication()
	 */
	@Override
	public RiskCommunication getValidatedRiskCommunication() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see eu.muses.sim.corporate.policy.rule.Rule#isValidated()
	 */
	@Override
	public boolean isValidated() {
		boolean validated = false;
		if (this.beforeTimeDate.before(new Date(System.currentTimeMillis()))) {
			validated = true;
		}
		return validated;
	}

}
