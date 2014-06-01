/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.context;

import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.vulnerability.Vulnerability;

/**
 * The Interface Contextable.
 */
public interface Contextable {

    /**
     * Gets the vulnerabilities.
     *
     * @return the vulnerabilities
     */
    public Vulnerability[] getVulnerabilities();

    /**
     * Checks if is under attack.
     *
     * @return the probability
     */
    public Probability isUnderAttack();

}
