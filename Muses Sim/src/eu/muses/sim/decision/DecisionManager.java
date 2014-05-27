package eu.muses.sim.decision;

import java.util.Collection;
import java.util.Iterator;

public class DecisionManager {

	/**
	 * @uml.property   name="decisions"
	 * @uml.associationEnd   multiplicity="(0 -1)" inverse="decisionManager:eu.muses.sim.decision.Decision"
	 * @uml.association   name="managesDecisions"
	 */
	private Collection<Decision> decisions = new java.util.Vector();

	/** 
	 * Getter of the property <tt>decisions</tt>
	 * @return  Returns the decisions.
	 * @uml.property  name="decisions"
	 */
	public Collection<Decision> getDecisions() {
		return decisions;
	}

	/**
	 * Returns an iterator over the elements in this collection. 
	 * @return  an <tt>Iterator</tt> over the elements in this collection
	 * @see java.util.Collection#iterator()
	 * @uml.property  name="decisions"
	 */
	public Iterator<Decision> decisionsIterator() {
		return decisions.iterator();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains no elements.
	 * @return  <tt>true</tt> if this collection contains no elements
	 * @see java.util.Collection#isEmpty()
	 * @uml.property  name="decisions"
	 */
	public boolean isDecisionsEmpty() {
		return decisions.isEmpty();
	}

	/**
	 * Returns <tt>true</tt> if this collection contains the specified element. 
	 * @param element  whose presence in this collection is to be tested.
	 * @see java.util.Collection#contains(Object)
	 * @uml.property  name="decisions"
	 */
	public boolean containsDecisions(Decision decision) {
		return decisions.contains(decision);
	}

	/**
	 * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
	 * @param elements  collection to be checked for containment in this collection.
	 * @see java.util.Collection#containsAll(Collection)
	 * @uml.property  name="decisions"
	 */
	public boolean containsAllDecisions(Collection<? extends Decision> decisions) {
		return this.decisions.containsAll(decisions);
	}

	/**
	 * Returns the number of elements in this collection.
	 * @return  the number of elements in this collection
	 * @see java.util.Collection#size()
	 * @uml.property  name="decisions"
	 */
	public int decisionsSize() {
		return decisions.size();
	}

	/**
	 * Returns all elements of this collection in an array.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray()
	 * @uml.property  name="decisions"
	 */
	public Decision[] decisionsToArray() {
		return decisions.toArray(new Decision[decisions.size()]);
	}

	/**
	 * Returns an array containing all of the elements in this collection;  the runtime type of the returned array is that of the specified array.
	 * @param a  the array into which the elements of this collection are to be stored.
	 * @return  an array containing all of the elements in this collection
	 * @see java.util.Collection#toArray(Object[])
	 * @uml.property  name="decisions"
	 */
	public <T extends Decision> T[] decisionsToArray(T[] decisions) {
		return (T[]) this.decisions.toArray(decisions);
	}

	/**
	 * Ensures that this collection contains the specified element (optional operation). 
	 * @param element  whose presence in this collection is to be ensured.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="decisions"
	 */
	public boolean addDecisions(Decision decision) {
		return decisions.add(decision);
	}

	/** 
	 * Setter of the property <tt>decisions</tt>
	 * @param decisions  the decisions to set.
	 * @uml.property  name="decisions"
	 */
	public void setDecisions(Collection<Decision> decisions) {
		this.decisions = decisions;
	}

	/**
	 * Removes a single instance of the specified element from this collection, if it is present (optional operation).
	 * @param element  to be removed from this collection, if present.
	 * @see java.util.Collection#add(Object)
	 * @uml.property  name="decisions"
	 */
	public boolean removeDecisions(Decision decision) {
		return decisions.remove(decision);
	}

	/**
	 * Removes all of the elements from this collection (optional operation).
	 * @see java.util.Collection#clear()
	 * @uml.property  name="decisions"
	 */
	public void clearDecisions() {
		decisions.clear();
	}

}
