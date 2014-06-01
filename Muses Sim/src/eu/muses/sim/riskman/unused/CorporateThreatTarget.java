/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.unused;

import eu.muses.sim.riskman.asset.Asset;

/**
 * The Class CorporateThreatTarget.
 */
public class CorporateThreatTarget extends ThreatTarget {

    /**
     * The assets.
     *
     * @uml.property name="asset"
     * @uml.associationEnd multiplicity="(0 -1)" dimension="1"
     *                     inverse="corporateThreatTarget:eu.muses.sim.riskman.asset.Asset"
     * @uml.association name="onAssets"
     */
    private Asset[] assets;

    /**
     * Gets the asset.
     *
     * @return the asset
     */
    public Asset[] getAsset() {
        return this.assets;
    }

    /**
     * Sets the asset.
     *
     * @param asset
     *            the new asset
     */
    public void setAsset(Asset[] asset) {
        this.assets = asset;
    }

}
