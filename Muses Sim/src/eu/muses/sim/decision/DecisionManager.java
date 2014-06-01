/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.decision;

import java.util.Collection;
import java.util.Iterator;

/**
 * The Class DecisionManager.
 */
public class DecisionManager {

    /**
     * The decisions.
     *
     * @uml.property name="decisions"
     * @uml.associationEnd multiplicity="(0 -1)" inverse="decisionManager:eu.muses.sim.decision.Decision"
     * @uml.association name="managesDecisions"
     */
    private Collection<Decision> decisions = new java.util.Vector();

    /**
     * Ensures that this collection contains the specified element (optional operation).
     *
     * @param decision
     *            the decision
     * @return true, if successful
     * @see java.util.Collection#add(Object)
     * @uml.property name="decisions"
     */
    public boolean addDecisions(Decision decision) {
        return this.decisions.add(decision);
    }

    /**
     * Removes all of the elements from this collection (optional operation).
     * 
     * @see java.util.Collection#clear()
     * @uml.property name="decisions"
     */
    public void clearDecisions() {
        this.decisions.clear();
    }

    /**
     * Returns <tt>true</tt> if this collection contains all of the elements in the specified collection.
     *
     * @param decisions
     *            the decisions
     * @return true, if successful
     * @see java.util.Collection#containsAll(Collection)
     * @uml.property name="decisions"
     */
    public boolean containsAllDecisions(Collection<? extends Decision> decisions) {
        return this.decisions.containsAll(decisions);
    }

    /**
     * Returns <tt>true</tt> if this collection contains the specified element.
     *
     * @param decision
     *            the decision
     * @return true, if successful
     * @see java.util.Collection#contains(Object)
     * @uml.property name="decisions"
     */
    public boolean containsDecisions(Decision decision) {
        return this.decisions.contains(decision);
    }

    /**
     * Returns an iterator over the elements in this collection.
     * 
     * @return an <tt>Iterator</tt> over the elements in this collection
     * @see java.util.Collection#iterator()
     * @uml.property name="decisions"
     */
    public Iterator<Decision> decisionsIterator() {
        return this.decisions.iterator();
    }

    /**
     * Returns the number of elements in this collection.
     * 
     * @return the number of elements in this collection
     * @see java.util.Collection#size()
     * @uml.property name="decisions"
     */
    public int decisionsSize() {
        return this.decisions.size();
    }

    /**
     * Returns all elements of this collection in an array.
     * 
     * @return an array containing all of the elements in this collection
     * @see java.util.Collection#toArray()
     * @uml.property name="decisions"
     */
    public Decision[] decisionsToArray() {
        return this.decisions.toArray(new Decision[this.decisions.size()]);
    }

    /**
     * Returns an array containing all of the elements in this collection; the runtime type of the returned array is
     * that of the specified array.
     *
     * @param <T>
     *            the generic type
     * @param decisions
     *            the decisions
     * @return an array containing all of the elements in this collection
     * @see java.util.Collection#toArray(Object[])
     * @uml.property name="decisions"
     */
    public <T extends Decision> T[] decisionsToArray(T[] decisions) {
        return this.decisions.toArray(decisions);
    }

    /**
     * Gets the decisions.
     *
     * @return the decisions
     */
    public Collection<Decision> getDecisions() {
        return this.decisions;
    }

    /**
     * Checks if is decisions empty.
     *
     * @return true, if is decisions empty
     */
    public boolean isDecisionsEmpty() {
        return this.decisions.isEmpty();
    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present (optional operation).
     *
     * @param decision
     *            the decision
     * @return true, if successful
     * @see java.util.Collection#add(Object)
     * @uml.property name="decisions"
     */
    public boolean removeDecisions(Decision decision) {
        return this.decisions.remove(decision);
    }

    /**
     * Sets the decisions.
     *
     * @param decisions
     *            the new decisions
     */
    public void setDecisions(Collection<Decision> decisions) {
        this.decisions = decisions;
    }

}
