package eu.muses.sim.riskman;

import eu.muses.sim.Outcome;

import java.util.Collection;
import java.util.Iterator;



public abstract class RiskEvent {

	/**
	 * @uml.property  name="probability"
	 */
	protected Probability probability;

	public RiskEvent(Probability probability, Collection<Outcome> outcomes) {
		super();
		this.probability = probability;
		this.outcome = outcome;
	}

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
	 * @uml.property  name="outcome"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="event:eu.muses.sim.Outcome"
	 * @uml.association  name="has"
	 */
	private Collection<Outcome> outcome;

	/**
	 * Getter of the property <tt>outcome</tt>
	 * @return  Returns the outcome.
	 * @uml.property  name="outcome"
	 */
	public Collection<Outcome> getOutcomes() {
		return outcome;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="outcome"
	 */
	public Iterator<Outcome> outcomesIterator() {
		return outcome.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="outcome"
	 */
	public boolean isOutcomesEmpty() {
		return outcome.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="outcome"
	 */
	public boolean containsOutcomes(Outcome outcome) {
		return this.outcome.contains(outcome);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="outcome"
	 */
	public int outcomesSize() {
		return outcome.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="outcome"
	 */
	public Outcome[] outcomesToArray() {
		return outcome.toArray(new Outcome[outcome.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="outcome"
	 */
	public <T extends Outcome> T[] outcomesToArray(T[] outcome) {
		return (T[]) this.outcome.toArray(outcome);
	}
	

	
}
