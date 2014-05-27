package eu.muses.sim.riskman.asset;

import eu.muses.sim.corporate.Corporation;


public class CorporateAsset extends Asset {
	
	private Corporation owningCorporation;

	public CorporateAsset(Corporation owningCorporation, double value) {
		super(value);
		this.owningCorporation = owningCorporation;
		this.value = value;
	}

	public Corporation getOwningCorporation() {
		return owningCorporation;
	}

	public double getValue() {
		return value;
	}

}
