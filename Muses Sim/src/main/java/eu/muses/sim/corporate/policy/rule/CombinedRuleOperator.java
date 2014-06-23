/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.corporate.policy.rule;

/**
 * The Class CombinedRuleOperator.
 */
public class CombinedRuleOperator {

	/** The Constant AND. */
	public static final CombinedRuleOperator AND = new CombinedRuleOperator(
			"AND");

	/** The Constant OR. */
	public static final CombinedRuleOperator OR = new CombinedRuleOperator("OR");

	/** The Constant NOT. */
	public static final CombinedRuleOperator NOT = new CombinedRuleOperator(
			"NOT");

	/**
	 * Instantiates a new combined rule operator.
	 *
	 * @param operatorName
	 *            the operator name
	 */
	public CombinedRuleOperator(String operatorName) {
	}

}
