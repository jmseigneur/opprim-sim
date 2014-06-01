/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

import eu.muses.sim.corporate.policy.CorporateSecurityPolicy;
import eu.muses.sim.riskman.threat.Threat;
import eu.muses.sim.riskman.vulnerability.Vulnerability;

/**
 * The Class RiskPolicy.
 */
public class RiskPolicy {

    /** The probability. */
    private Probability probability;

    /** The cost benefit. */
    private CostBenefit costBenefit;

    /** The test no risk. */
    public static RiskPolicy TEST_NO_RISK = new RiskPolicy(RiskValue.NO_RISK, null);

    /**
     * Instantiates a new risk policy.
     *
     * @param noRisk
     *            the no risk
     * @param corporateSecurityPolicy
     *            the corporate security policy
     */
    public RiskPolicy(RiskValue noRisk, CorporateSecurityPolicy corporateSecurityPolicy) {
    }

    /**
     * Compute risk.
     *
     * @param vulnerabilities
     *            the vulnerabilities
     * @param threats
     *            the threats
     * @param assetsValues
     *            the assets values
     * @return the double
     */
    public double computeRisk(Vulnerability[] vulnerabilities, Threat[] threats, double[] assetsValues) {
        return 0;
    }

    /**
     * Gets the cost benefit.
     *
     * @return the cost benefit
     */
    public CostBenefit getCostBenefit() {
        return this.costBenefit;
    }

    /**
     * Gets the probability.
     *
     * @return the probability
     */
    public Probability getProbability() {
        return this.probability;
    }

}
