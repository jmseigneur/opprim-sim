/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

/**
 * The Class RiskTreatment.
 */
public class RiskTreatment {

    /** The Constant PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY. */
    public static final RiskTreatment PROVIDE_A_DESCRIPTION_OF_YOUR_OPPORTUNITY = new RiskTreatment(
            "Please provide a description of your opportunity");

    /** The Constant RECONNECT. */
    public static final RiskTreatment RECONNECT = new RiskTreatment(
            "You have been disconnected too long. Please provide a description of your opportunity");

    /**
     * Instantiates a new risk treatment.
     *
     * @param textualDescription
     *            the textual description
     */
    public RiskTreatment(String textualDescription) {
    }

}
