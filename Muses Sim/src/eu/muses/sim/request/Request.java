package eu.muses.sim.request;

import eu.muses.sim.riskman.RiskEvent;

public class Request {

	/**
	 * @uml.property  name="riskEvent"
	 * @uml.associationEnd  multiplicity="(0 -1)" dimension="1" inverse="request:eu.muses.sim.riskman.RiskEvent"
	 * @uml.association  name="generates"
	 */
	private RiskEvent[] riskEvents;

	/**
	 * Getter of the property <tt>riskEvent</tt>
	 * @return  Returns the riskEvents.
	 * @uml.property  name="riskEvent"
	 */
	public RiskEvent[] getRiskEvent() {
		return riskEvents;
	}

	/**
	 * Setter of the property <tt>riskEvent</tt>
	 * @param riskEvent  The riskEvents to set.
	 * @uml.property  name="riskEvent"
	 */
	public void setRiskEvent(RiskEvent[] riskEvent) {
		riskEvents = riskEvent;
	}

}
