package eu.muses.sim.decision;

import eu.muses.sim.riskman.RiskCommunication;


abstract public class Decision {

	public static final CorporateUserAccessRequestDecision ALLOW_ACCESS = new CorporateUserAccessRequestDecision("Access is allowed by MUSES");

	public static final CorporateUserAccessRequestDecision MAYBE_ACCESS = new CorporateUserAccessRequestDecision("Access is denied but may be allowed if some risk treatments are carried out");
	
	public static final CorporateUserAccessRequestDecision ON_YOUR_RISK_ACCESS = new CorporateUserAccessRequestDecision("Access is up to the user");

	public static final CorporateUserAccessRequestDecision STRONG_DENY_ACCESS = new CorporateUserAccessRequestDecision("Access is strongly denied and no risk treatment is possible");
	
	/**
	 * @uml.property  name="riskCommunication"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="decision:eu.muses.sim.riskman.RiskCommunication"
	 * @uml.association  name="has"
	 */
	private RiskCommunication riskCommunication = new eu.muses.sim.riskman.RiskCommunication();

	/**
	 * Getter of the property <tt>riskCommunication</tt>
	 * @return  Returns the riskCommunication.
	 * @uml.property  name="riskCommunication"
	 */
	public RiskCommunication getRiskCommunication() {
		return riskCommunication;
	}

	/**
	 * Setter of the property <tt>riskCommunication</tt>
	 * @param riskCommunication  The riskCommunication to set.
	 * @uml.property  name="riskCommunication"
	 */
	public void setRiskCommunication(RiskCommunication riskCommunication) {
		this.riskCommunication = riskCommunication;
	}
	

}
