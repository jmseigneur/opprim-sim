/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import eu.muses.sim.Outcome;

/**
 * The Class RiskEvent.
 */
public abstract class RiskEvent {

	/**
	 * The probability.
	 *
	 * @uml.property name="probability"
	 */
	protected Probability probability;

	/**
	 * The outcome.
	 *
	 * @uml.property name="outcome"
	 * @uml.associationEnd multiplicity="(0 -1)"
	 *                     inverse="event:eu.muses.sim.Outcome"
	 * @uml.association name="has"
	 */
	private Collection<Outcome> outcome = new Vector<Outcome>();

	private double occurences = 0;
	private double badOutcomeCount = 0;

	/**
	 * Instantiates a new risk event.
	 *
	 * @param probability
	 *            the probability
	 * @param outcomes
	 *            the outcomes
	 */
	public RiskEvent(Probability probability, Collection<Outcome> outcomes) {
		super();
		this.probability = probability;
		this.outcome = outcomes;
	}

	/**
	 * Instantiates a new risk event with a single possible outcome.
	 *
	 * @param probability
	 *            the probability
	 * @param outcome
	 *            the single outcome
	 */
	public RiskEvent(Probability probability, Outcome outcome) {
		super();
		this.probability = probability;
		this.outcome.add(outcome);
	}

	public RiskEvent() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element.
	 *
	 * @param outcome
	 *            the outcome
	 * @return true, if successful
	 * @see java.util.Collection#contains(Object)
	 * @uml.property name="outcome"
	 */
	public boolean containsOutcomes(Outcome outcome) {
		return this.outcome.contains(outcome);
	}

	/**
	 * Gets the outcomes.
	 *
	 * @return the outcomes
	 */
	public Collection<Outcome> getOutcomes() {
		return this.outcome;
	}

	/**
	 * Gets the probability.
	 *
	 * @return the probability
	 */
	public Probability getProbability() {
		return this.probability;
	}

	/**
	 * Checks if is outcomes empty.
	 *
	 * @return true, if is outcomes empty
	 */
	public boolean isOutcomesEmpty() {
		return this.outcome.isEmpty();
	}

	/**
	 * Returns an iterator over the elements in this collection.
	 * 
	 * @return an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property name="outcome"
	 */
	public Iterator<Outcome> outcomesIterator() {
		return this.outcome.iterator();
	}

	/**
	 * Returns the number of elements in this collection.
	 * 
	 * @return the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property name="outcome"
	 */
	public int outcomesSize() {
		return this.outcome.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * 
	 * @return an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property name="outcome"
	 */
	public Outcome[] outcomesToArray() {
		return this.outcome.toArray(new Outcome[this.outcome.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection; the
	 * runtime type of the returned array is that of the specified array.
	 *
	 * @param <T>
	 *            the generic type
	 * @param outcome
	 *            the outcome
	 * @return an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property name="outcome"
	 */
	public <T extends Outcome> T[] outcomesToArray(T[] outcome) {
		return this.outcome.toArray(outcome);
	}

	/**
	 * Sets the probability.
	 *
	 * @param probability
	 *            the new probability
	 */
	public void setProbability(Probability probability) {
		this.probability = probability;
	}

	public double getOccurences() {
		return occurences;
	}

	public void setOccurences(double occurences) {
		this.occurences = occurences;
	}

	public double getBadOutcomeCount() {
		return badOutcomeCount;
	}

	public void setBadOutcomeCount(double badOutcomeCount) {
		this.badOutcomeCount = badOutcomeCount;
	}

}
