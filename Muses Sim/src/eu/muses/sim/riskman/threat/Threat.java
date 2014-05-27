package eu.muses.sim.riskman.threat;

import java.util.Collection;
import java.util.Iterator;

import eu.muses.sim.Outcome;
import eu.muses.sim.riskman.Probability;
import eu.muses.sim.riskman.RiskEvent;
import eu.muses.sim.riskman.vulnerability.Vulnerability;


public class Threat extends RiskEvent {

	/**
	 * @uml.property  name="probability"
	 */
	private Probability probability;

	/**
	 * Getter of the property <tt>probability</tt>
	 * @return  Returns the probability.
	 * @uml.property  name="probability"
	 */
	public Probability getProbability() {
		return probability;
	}

	/**
	 * Setter of the property <tt>probability</tt>
	 * @param probability  The probability to set.
	 * @uml.property  name="probability"
	 */
	public void setProbability(Probability probability) {
		this.probability = probability;
	}

	/** 
	 * @uml.property name="vulnerabilities"
	 * @uml.associationEnd multiplicity="(0 -1)" inverse="threat:eu.muses.sim.riskman.vulnerability.Vulnerability"
	 * @uml.association name="exploits"
	 */
	private Collection<Vulnerability> vulnerabilities;

	private String description;

	public Threat(String description, Probability probability, Collection<Outcome> outcomes) {
		super(probability, outcomes);
		this.description = description;
	}

	/**
	 * Getter of the property <tt>vulnerabilities</tt>
	 * @return  Returns the vulnerability.
	 * @uml.property  name="vulnerabilities"
	 */
	public Collection<Vulnerability> getVulnerabilities() {
		return vulnerabilities;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="vulnerabilities"
	 */
	public Iterator<Vulnerability> vulnerabilitiesIterator() {
		return vulnerabilities.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="vulnerabilities"
	 */
	public boolean isVulnerabilitiesEmpty() {
		return vulnerabilities.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="vulnerabilities"
	 */
	public boolean containsVulnerabilities(Vulnerability vulnerability) {
		return vulnerabilities.contains(vulnerability);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="vulnerabilities"
	 */
	public boolean containsAllVulnerabilities(
			Collection<? extends Vulnerability> vulnerabilities) {
		return vulnerabilities.containsAll(vulnerabilities);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="vulnerabilities"
	 */
	public int vulnerabilitiesSize() {
		return vulnerabilities.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="vulnerabilities"
	 */
	public Vulnerability[] vulnerabilitiesToArray() {
		return vulnerabilities.toArray(new Vulnerability[vulnerabilities.size()]);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="vulnerabilities"
	 */
	public boolean addVulnerabilities(Vulnerability vulnerability) {
		return vulnerabilities.add(vulnerability);
	}

	/**
	 * Setter of the property <tt>vulnerabilities</tt>
	 * @param vulnerabilities  the vulnerability to set.
	 * @uml.property  name="vulnerabilities"
	 */
	public void setVulnerabilities(Collection<Vulnerability> vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="vulnerabilities"
	 */
	public boolean removeVulnerabilities(Vulnerability vulnerability) {
		return vulnerabilities.remove(vulnerability);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="vulnerabilities"
	 */
	public void clearVulnerabilities() {
		vulnerabilities.clear();
	}

}
