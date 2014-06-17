/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.corporate.policy.rule;

import eu.muses.sim.riskman.RiskCommunication;

/**
 * The Class CombinedRule.
 */
public class CombinedRule extends Rule {

	/** The rule1. */
	private final Rule rule1;

	/** The rule2. */
	private final Rule rule2;

	/** The combined rule operator. */
	private final CombinedRuleOperator combinedRuleOperator;

	/**
	 * Instantiates a new combined rule.
	 *
	 * @param rule1
	 *            the rule1
	 * @param rule2
	 *            the rule2
	 * @param combinedRuleOperator
	 *            the combined rule operator
	 */
	public CombinedRule(Rule rule1, Rule rule2,
			CombinedRuleOperator combinedRuleOperator) {
		this.rule1 = rule1;
		this.rule2 = rule2;
		this.combinedRuleOperator = combinedRuleOperator;
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
		if (this.combinedRuleOperator.equals(CombinedRuleOperator.AND)) {
			validated = this.rule1.isValidated() && this.rule2.isValidated();
		} else {
			if (this.combinedRuleOperator.equals(CombinedRuleOperator.OR)) {
				validated = this.rule1.isValidated()
						|| this.rule2.isValidated();
			} else {
				if (this.combinedRuleOperator.equals(CombinedRuleOperator.NOT)) {
					validated = !this.rule1.isValidated();
				} else {
					System.out
							.println("Unknown rule combiner operator : exiting");
					System.exit(-1);
				}
			}
		}
		return validated;
	}

}
