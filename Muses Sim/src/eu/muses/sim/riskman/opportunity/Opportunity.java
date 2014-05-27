package eu.muses.sim.riskman.opportunity;

import java.util.Collection;

import eu.muses.sim.OpportunityDescriptor;
import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;


public class Opportunity extends RiskEvent {
		
	private String description;

	public Opportunity(String description, Probability probability, Collection<Outcome> outcomes) {
		super(probability, outcomes);
		this.description = description;
	}

	/**
	 * @uml.property  name="opportunityDescriptor"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="opportunity:eu.muses.sim.OpportunityDescriptor"
	 * @uml.association  name="has"
	 */
	private OpportunityDescriptor opportunityDescriptor = new eu.muses.sim.OpportunityDescriptor();

	/**
	 * Getter of the property <tt>opportunityDescriptor</tt>
	 * @return  Returns the opportunityDescriptor.
	 * @uml.property  name="opportunityDescriptor"
	 */
	public OpportunityDescriptor getOpportunityDescriptor() {
		return opportunityDescriptor;
	}

	/**
	 * Setter of the property <tt>opportunityDescriptor</tt>
	 * @param opportunityDescriptor  The opportunityDescriptor to set.
	 * @uml.property  name="opportunityDescriptor"
	 */
	public void setOpportunityDescriptor(
			OpportunityDescriptor opportunityDescriptor) {
		this.opportunityDescriptor = opportunityDescriptor;
	}

}
