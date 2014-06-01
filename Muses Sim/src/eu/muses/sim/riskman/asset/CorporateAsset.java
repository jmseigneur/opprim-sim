/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.asset;

import eu.muses.sim.corporate.Corporation;

/**
 * The Class CorporateAsset.
 */
public class CorporateAsset extends Asset {

    /** The owning corporation. */
    private Corporation owningCorporation;

    /**
     * Instantiates a new corporate asset.
     *
     * @param assetDescription
     *            the asset description
     * @param owningCorporation
     *            the owning corporation
     * @param value
     *            the value
     */
    public CorporateAsset(String assetDescription, Corporation owningCorporation, double value) {
        super(assetDescription, value);
        this.owningCorporation = owningCorporation;
        this.value = value;
    }

    /**
     * Gets the owning corporation.
     *
     * @return the owning corporation
     */
    public Corporation getOwningCorporation() {
        return this.owningCorporation;
    }

    /*
     * (non-Javadoc)
     * @see eu.muses.sim.riskman.asset.Asset#getValue()
     */
    @Override
    public double getValue() {
        return this.value;
    }

}
