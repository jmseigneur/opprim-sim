/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.trustman;

import eu.muses.sim.context.Contextable;

/**
 * The Class ContextTrustValue.
 */
public class ContextTrustValue extends TrustValue {

    /**
     * The contextable.
     *
     * @uml.property name="contextable"
     * @uml.associationEnd multiplicity="(1 1)" inverse="contextTrust:eu.muses.sim.context.Contextable"
     */
    private Contextable contextable;

    /**
     * Gets the context.
     *
     * @return the context
     */
    public Contextable getContext() {
        return this.contextable;
    }

    /**
     * Sets the context.
     *
     * @param contextable
     *            the new context
     */
    public void setContext(Contextable contextable) {
        this.contextable = contextable;
    }

}
