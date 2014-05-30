package eu.muses.sim;

import java.util.Collection;
import java.util.Vector;

import eu.muses.sim.riskman.asset.Asset;


public class OpportunityDescriptor {
	
	private String description;
	
	private Collection<Asset> requestedAssets = new Vector<Asset>();
	
	private Collection<Outcome> outcomes = new Vector<Outcome>();
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void addRequestedAsset(Asset asset) {
		requestedAssets.add(asset);
	}

	public void addOutcome(Outcome outcome) {
		outcomes.add(outcome);
	}

	public Collection<Asset> getRequestedAssets() {
		return requestedAssets;
	}

	public Collection<Outcome> getOutcomes() {
		return outcomes;
	}

	public String getDescription() {
		return description;
	}
	
}
