/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.opportunity;

import java.util.Collection;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;

/**
 * The Class WorkAtTheAirport.
 */
public class WorkAtTheAirport extends Opportunity {

	/**
	 * Instantiates a new work at the airport.
	 *
	 * @param description
	 *            the description
	 * @param probability
	 *            the probability
	 * @param outcomes
	 *            the outcomes
	 */
	public WorkAtTheAirport(String description, Probability probability,
			Collection<Outcome> outcomes) {
		super(description, probability, outcomes);
		// TODO Auto-generated constructor stub
	}

}
