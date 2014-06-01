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
 * The Class Rule.
 */
public abstract class Rule {

    /**
     * Gets the not validated risk communication.
     *
     * @return the not validated risk communication
     */
    public abstract RiskCommunication getNotValidatedRiskCommunication();

    /**
     * Gets the validated risk communication.
     *
     * @return the validated risk communication
     */
    public abstract RiskCommunication getValidatedRiskCommunication();

    /**
     * Checks if is validated.
     *
     * @return true, if is validated
     */
    public abstract boolean isValidated();

}
