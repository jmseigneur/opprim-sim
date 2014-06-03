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
    public final static RiskValue TAKE_FULL_RISK = new RiskValue(0.0);

    /** The Constant NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY. */
    public final static RiskValue TAKE_NO_MORE_RISK_THAN_CREATED_BY_CORPORATE_SECURITY_POLICY = new RiskValue(new Random().nextDouble());

    /** The Constant TAKE_NO_RISK. */
    public final static RiskValue TAKE_NO_RISK = new RiskValue(1.0);
    
    /** The Constant TAKE_AVERAGE_MEDIUM_RISK. */
    public final static RiskValue TAKE_AVERAGE_RISK = new RiskValue(0.5);

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
