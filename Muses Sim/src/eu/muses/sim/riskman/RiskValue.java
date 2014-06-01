/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

/**
 * The Class RiskValue.
 */
public class RiskValue {

    /** The Constant FULL_RISK. */
    public final static RiskValue FULL_RISK = new RiskValue(0.0);

    /** The Constant NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY. */
    public final static RiskValue NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY = new RiskValue(0.0);

    /** The Constant NO_RISK. */
    public final static RiskValue NO_RISK = new RiskValue(1.0);

    /** The value. */
    private double value;

    /**
     * Instantiates a new risk value.
     *
     * @param value
     *            the value
     */
    public RiskValue(double value) {
        super();
        this.value = value;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public double getValue() {
        return this.value;
    }

}
