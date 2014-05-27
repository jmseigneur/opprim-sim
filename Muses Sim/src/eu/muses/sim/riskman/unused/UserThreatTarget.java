package eu.muses.sim.riskman.unused;

import eu.muses.sim.riskman.asset.Asset;


public class UserThreatTarget extends ThreatTarget {

	/**
	 * @uml.property   name="asset"
	 * @uml.associationEnd   multiplicity="(0 -1)" dimension="1" inverse="userThreatTarget:eu.muses.sim.riskman.asset.Asset"
	 * @uml.association   name="onAssets"
	 */
	private Asset[] asset;

	/** 
	 * Getter of the property <tt>asset</tt>
	 * @return  Returns the asset.
	 * @uml.property  name="asset"
	 */
	public Asset[] getAsset() {
		return asset;
	}

	/** 
	 * Setter of the property <tt>asset</tt>
	 * @param asset  The asset to set.
	 * @uml.property  name="asset"
	 */
	public void setAsset(Asset[] asset) {
		this.asset = asset;
	}

}
