/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.request;

import eu.muses.sim.riskman.RiskEvent;

/**
 * The Class Request.
 */
public class Request {

	/**
	 * The risk events.
	 *
	 * @uml.property name="riskEvent"
	 * @uml.associationEnd multiplicity="(0 -1)" dimension="1"
	 *                     inverse="request:eu.muses.sim.riskman.RiskEvent"
	 * @uml.association name="generates"
	 */
	private RiskEvent[] riskEvents;

	/**
	 * Gets the risk event.
	 *
	 * @return the risk event
	 */
	public RiskEvent[] getRiskEvent() {
		return this.riskEvents;
	}

	/**
	 * Sets the risk event.
	 *
	 * @param riskEvent
	 *            the new risk event
	 */
	public void setRiskEvent(RiskEvent[] riskEvent) {
		this.riskEvents = riskEvent;
	}

}
