package eu.muses.sim.riskman.unused;

import eu.muses.sim.riskman.asset.Asset;


public class CorporateThreatTarget extends ThreatTarget {

	/**
	 * @uml.property   name="asset"
	 * @uml.associationEnd   multiplicity="(0 -1)" dimension="1" inverse="corporateThreatTarget:eu.muses.sim.riskman.asset.Asset"
	 * @uml.association   name="onAssets"
	 */
	private Asset[] assets;

	/**
	 * Getter of the property <tt>asset</tt>
	 * @return  Returns the assets.
	 * @uml.property  name="asset"
	 */
	public Asset[] getAsset() {
		return assets;
	}

	/**
	 * Setter of the property <tt>asset</tt>
	 * @param asset  The assets to set.
	 * @uml.property  name="asset"
	 */
	public void setAsset(Asset[] asset) {
		assets = asset;
	}

}
