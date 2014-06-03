/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.opportunity;

import java.util.Collection;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;

/**
 * The Class Opportunity.
 */
public class Opportunity extends RiskEvent {

    /**
     * The opportunity descriptor.
     *
     * @uml.property name="opportunityDescriptor"
     * @uml.associationEnd multiplicity="(1 1)" inverse="opportunity:eu.muses.sim.OpportunityDescriptor"
     * @uml.association name="has"
     */
    private OpportunityDescriptor opportunityDescriptor = new eu.muses.sim.OpportunityDescriptor();
    
    /** The textual description */
    private String description;

    /**
     * Instantiates a new opportunity.
     *
     * @param description
     *            the description
     * @param probability
     *            the probability
     * @param outcomes
     *            the outcomes
     */
    public Opportunity(String description, Probability probability, Collection<Outcome> outcomes) {
        super(probability, outcomes);
        this.description = description;
    }
    
    public Opportunity(String description, Probability probability, Outcome outcome) {
        super(probability, outcome);
        this.description = description;
    }

    /**
     * Gets the opportunity descriptor.
     *
     * @return the opportunity descriptor
     */
    public OpportunityDescriptor getOpportunityDescriptor() {
        return this.opportunityDescriptor;
    }

    /**
     * Sets the opportunity descriptor.
     *
     * @param opportunityDescriptor
     *            the new opportunity descriptor
     */
    public void setOpportunityDescriptor(OpportunityDescriptor opportunityDescriptor) {
        this.opportunityDescriptor = opportunityDescriptor;
    }

}
