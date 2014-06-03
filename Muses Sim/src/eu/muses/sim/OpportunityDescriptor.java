/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim;

import java.util.Collection;
import java.util.Vector;

import eu.muses.sim.riskman.asset.Asset;

/**
 * The Class OpportunityDescriptor.
 */
public class OpportunityDescriptor {

	/** The description. */
	private String description;

	/** The requested assets. */
	private Collection<Asset> requestedAssets = new Vector<Asset>();

	/** The outcomes. */
	private Collection<Outcome> outcomes = new Vector<Outcome>();

	public OpportunityDescriptor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OpportunityDescriptor(String description,
			Collection<Asset> requestedAssets, Outcome outcome) {
		super();
		this.description = description;
		this.requestedAssets = requestedAssets;
		this.outcomes.add(outcome);
	}

	/**
	 * Adds the requested asset.
	 * 
	 * @param asset
	 *            the asset
	 */
	public void addRequestedAsset(Asset asset) {
		this.requestedAssets.add(asset);
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the outcomes.
	 * 
	 * @return the outcomes
	 */
	public Collection<Outcome> getOutcomes() {
		return this.outcomes;
	}
	
	public void addOutcome(Outcome outcome){
		
		this.outcomes.add(outcome);
		
	}

	/**
	 * Gets the requested assets.
	 * 
	 * @return the requested assets
	 */
	public Collection<Asset> getRequestedAssets() {
		return this.requestedAssets;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
