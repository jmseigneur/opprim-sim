/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.decision;

/**
 * The Class CorporateUserAccessRequestDecision.
 */
public class CorporateUserAccessRequestDecision extends Decision {

    /** The textual decision description. */
    private String textualDecisionDescription;

    /**
     * Instantiates a new corporate user access request decision.
     *
     * @param textualDecisionDescription
     *            the textual decision description
     */
    public CorporateUserAccessRequestDecision(String textualDecisionDescription) {
        this.textualDecisionDescription = textualDecisionDescription;
    }

    /**
     * Gets the textual decision description.
     *
     * @return the textual decision description
     */
    public String getTextualDecisionDescription() {
        return this.textualDecisionDescription;
    }

    /**
     * Sets the textual decision description.
     *
     * @param textualDecisionDescription
     *            the new textual decision description
     */
    public void setTextualDecisionDescription(String textualDecisionDescription) {
        this.textualDecisionDescription = textualDecisionDescription;
    }

}
