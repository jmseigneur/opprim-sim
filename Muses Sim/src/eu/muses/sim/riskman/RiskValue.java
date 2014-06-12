/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

import java.util.Random;

/**
 * The Class RiskValue.
 */
public class RiskValue {

    /** The Constant TAKE_FULL_RISK. */
    public final static RiskValue TAKE_FULL_RISK = new RiskValue(0.0, "Always take full risk");

    /** The Constant NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY. */
    public final static RiskValue TAKE_NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY = new RiskValue(new Random().nextDouble(), "Take the risk defined by the company's corporate policy");

    /** The Constant TAKE_NO_RISK. */
    public final static RiskValue TAKE_NO_RISK = new RiskValue(1.0, "Never take any risk");
    
    /** The Constant TAKE_AVERAGE_MEDIUM_RISK. */
    public final static RiskValue TAKE_AVERAGE_RISK = new RiskValue(0.5, "Take an average risk");

    /** The value. */
    private double value;
    private String description;

    /**
     * Instantiates a new risk value.
     *
     * @param value
     *            the value
     */
    public RiskValue(double value, String description) {
        super();
        this.value = value;
        this.description = description;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public double getValue() {
        return this.value;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.description + " - " + this.value;
	}

    
}
