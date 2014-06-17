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

	/** The RiskValue. */
	private RiskValue riskValue;

	/** The corporate security policy. */
	private CorporateSecurityPolicy corporateSecurityPolicy;

	/** The test no risk. */
	public static RiskPolicy TAKE_NO_RISK = new RiskPolicy(
			RiskValue.TAKE_NO_RISK, null);
	public static RiskPolicy TAKE_FULL_RISK = new RiskPolicy(
			RiskValue.TAKE_FULL_RISK, null);
	public static RiskPolicy TAKE_MEDIUM_RISK = new RiskPolicy(
			RiskValue.TAKE_AVERAGE_RISK, null);
	public static RiskPolicy TAKE_CORPORATE_RISK = new RiskPolicy(
			RiskValue.TAKE_NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY,
			null);

	/**
	 * Instantiates a new risk policy.
	 *
	 * @param noRisk
	 *            the no risk
	 * @param corporateSecurityPolicy
	 *            the corporate security policy
	 */
	public RiskPolicy(RiskValue noRisk,
			CorporateSecurityPolicy corporateSecurityPolicy) {
		super();
		this.riskValue = noRisk;
		this.corporateSecurityPolicy = corporateSecurityPolicy;
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
	public double computeRisk(Vulnerability[] vulnerabilities,
			Threat[] threats, double[] assetsValues) {
		return 0;
	}

	public RiskValue getRiskValue() {
		return riskValue;
	}

	public void setRiskValue(RiskValue riskValue) {
		this.riskValue = riskValue;
	}

	public CorporateSecurityPolicy getCorporateSecurityPolicy() {
		return corporateSecurityPolicy;
	}

	public void setCorporateSecurityPolicy(
			CorporateSecurityPolicy corporateSecurityPolicy) {
		this.corporateSecurityPolicy = corporateSecurityPolicy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.riskValue.toString();
	}

}
