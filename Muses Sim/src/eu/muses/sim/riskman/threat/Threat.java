/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman.threat;

import java.util.Collection;
import java.util.Iterator;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.vulnerability.Vulnerability;

/**
 * The Class Threat.
 */
public class Threat extends RiskEvent {

    /**
     * The probability.
     *
     * @uml.property name="probability"
     */
    private Probability probability;

    /**
     * @uml.property name="vulnerabilities"
     * @uml.associationEnd multiplicity="(0 -1)" inverse="threat:eu.muses.sim.riskman.vulnerability.Vulnerability"
     * @uml.association name="exploits"
     */
    private Collection<Vulnerability> vulnerabilities;

    /** The description. */
    private String description;

    /**
     * Instantiates a new threat.
     *
     * @param description
     *            the description
     * @param probability
     *            the probability
     * @param outcomes
     *            the outcomes
     */
    public Threat(String description, Probability probability, Collection<Outcome> outcomes) {
        super(probability, outcomes);
        this.description = description;
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
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /*
     * (non-Javadoc)
     * @see eu.muses.sim.riskman.RiskEvent#getProbability()
     */
    @Override
    public Probability getProbability() {
        return this.probability;
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
     * Sets the description.
     *
     * @param description
     *            the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /*
     * (non-Javadoc)
     * @see eu.muses.sim.riskman.RiskEvent#setProbability(eu.muses.sim.riskman.Probability)
     */
    @Override
    public void setProbability(Probability probability) {
        this.probability = probability;
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
