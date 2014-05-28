package eu.muses.sim.trustman;

import eu.muses.sim.context.Contextable;


public class ContextTrustValue extends TrustValue {

	/**
	 * @uml.property   name="contextable"
	 * @uml.associationEnd   multiplicity="(1 1)" inverse="contextTrust:eu.muses.sim.context.Contextable"
	 */
	private Contextable contextable;

	/**
	 * Getter of the property <tt>contextable</tt>
	 * @return  Returns the contextable.
	 * @uml.property  name="contextable"
	 */
	public Contextable getContext() {
		return contextable;
	}

	/**
	 * Setter of the property <tt>contextable</tt>
	 * @param contextable  The contextable to set.
	 * @uml.property  name="contextable"
	 */
	public void setContext(Contextable contextable) {
		this.contextable = contextable;
	}

}
