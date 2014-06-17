/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.threat;

import java.util.Collection;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;

/**
 * The Class AccessThreat.
 */
public class AccessThreat extends Threat {

	/**
	 * Instantiates a new access threat.
	 *
	 * @param description
	 *            the description
	 * @param probability
	 *            the probability
	 * @param outcomes
	 *            the outcomes
	 */
	public AccessThreat(String description, Probability probability,
			Collection<Outcome> outcomes) {
		super(description, probability, outcomes);
		// TODO Auto-generated constructor stub
	}

}
