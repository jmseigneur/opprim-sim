/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.asset;

import java.util.Collection;
import java.util.Iterator;

import eu.muses.sim.riskman.vulnerability.Vulnerability;

/**
 * The Class Asset.
 */
public class Asset {

    /** The value. */
    protected double value;

    /** The asset name. */
    protected String assetName;

    /**
     * @uml.property name="vulnerabilities"
     * @uml.associationEnd multiplicity="(0 -1)" inverse="asset:eu.muses.sim.riskman.vulnerability.Vulnerability"
     * @uml.association name="has"
     */
    private Collection<Vulnerability> vulnerabilities = new java.util.Vector();

    /**
     * Instantiates a new asset.
     *
     * @param assetName
     *            the asset name
     * @param value
     *            the value
     */
    public Asset(String assetName, double value) {
        super();
        this.value = value;
        this.assetName = assetName;
    }

    /**
     * Ensures that this collection contains the specified element (optional operation).
     *
     * @param vulnerability
     *            the vulnerability
     * @return true, if successful
     * @see java.util.Collection#add(Object)
     * @uml.property name="vulnerabilities"
     */
    public boolean addVulnerabilities(Vulnerability vulnerability) {
        return this.vulnerabilities.add(vulnerability);
    }

    /**
     * Removes all of the elements from this collection (optional operation).
     * 
     * @see java.util.Collection#clear()
     * @uml.property name="vulnerabilities"
     */
    public void clearVulnerabilities() {
        this.vulnerabilities.clear();
    }

    /**
     * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
     *
     * @param vulnerabilities
     *            the vulnerabilities
     * @return true, if successful
     * @see java.util.Collection#containsAll(Collection)
     * @uml.property name="vulnerabilities"
     */
    public boolean containsAllVulnerabilities(Collection<? extends Vulnerability> vulnerabilities) {
        return vulnerabilities.containsAll(vulnerabilities);
    }

    /**
     * Returns <tt>true</tt> if this collection contains the specified element.
     *
     * @param vulnerability
     *            the vulnerability
     * @return true, if successful
     * @see java.util.Collection#contains(Object)
     * @uml.property name="vulnerabilities"
     */
    public boolean containsVulnerabilities(Vulnerability vulnerability) {
        return this.vulnerabilities.contains(vulnerability);
    }

    /**
     * Gets the asset name.
     *
     * @return the asset name
     */
    public String getAssetName() {
        return this.assetName;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Gets the vulnerabilities.
     *
     * @return the vulnerabilities
     */
    public Collection<Vulnerability> getVulnerabilities() {
        return this.vulnerabilities;
    }

    /**
     * Checks if is vulnerabilities empty.
     *
     * @return true, if is vulnerabilities empty
     */
    public boolean isVulnerabilitiesEmpty() {
        return this.vulnerabilities.isEmpty();
    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present (optional operation).
     *
     * @param vulnerability
     *            the vulnerability
     * @return true, if successful
     * @see java.util.Collection#add(Object)
     * @uml.property name="vulnerabilities"
     */
    public boolean removeVulnerabilities(Vulnerability vulnerability) {
        return this.vulnerabilities.remove(vulnerability);
    }

    /**
     * Sets the vulnerabilities.
     *
     * @param vulnerabilities
     *            the new vulnerabilities
     */
    public void setVulnerabilities(Collection<Vulnerability> vulnerabilities) {
        this.vulnerabilities = vulnerabilities;
    }

    /**
     * Returns an iterator over the elements in this collection.
     * 
     * @return an <tt>Iterator</tt> over the elements in this collection
     * @see java.util.Collection#iterator()
     * @uml.property name="vulnerabilities"
     */
    public Iterator<Vulnerability> vulnerabilitiesIterator() {
        return this.vulnerabilities.iterator();
    }

    /**
     * Returns the number of elements in this collection.
     * 
     * @return the number of elements in this collection
     * @see java.util.Collection#size()
     * @uml.property name="vulnerabilities"
     */
    public int vulnerabilitiesSize() {
        return this.vulnerabilities.size();
    }

    /**
     * Returns all elements of this collection in an array.
     * 
     * @return an array containing all of the elements in this collection
     * @see java.util.Collection#toArray()
     * @uml.property name="vulnerabilities"
     */
    public Vulnerability[] vulnerabilitiesToArray() {
        return this.vulnerabilities.toArray(new Vulnerability[this.vulnerabilities.size()]);
    }

}
