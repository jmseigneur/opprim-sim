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
 * The Class UserThreatTarget.
 */
public class UserThreatTarget extends ThreatTarget {

    /**
     * The asset.
     *
     * @uml.property name="asset"
     * @uml.associationEnd multiplicity="(0 -1)" dimension="1"
     *                     inverse="userThreatTarget:eu.muses.sim.riskman.asset.Asset"
     * @uml.association name="onAssets"
     */
    private Asset[] asset;

    /**
     * Gets the asset.
     *
     * @return the asset
     */
    public Asset[] getAsset() {
        return this.asset;
    }

    /**
     * Sets the asset.
     *
     * @param asset
     *            the new asset
     */
    public void setAsset(Asset[] asset) {
        this.asset = asset;
    }

}
