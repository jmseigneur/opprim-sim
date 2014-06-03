/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

/**
 * The Class Probability.
 */
public class Probability {

    /** The prob. */
    private double prob;

    /**
     * Instantiates a new probability.
     */
    public Probability() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new probability.
     *
     * @param prob
     *            the prob
     */
    public Probability(double prob) {
        this.prob = prob;
    }

	public double getProb() {
		return prob;
	}

	public void setProb(double prob) {
		this.prob = prob;
	}

}
