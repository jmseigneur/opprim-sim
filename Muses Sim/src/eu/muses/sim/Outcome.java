/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim;

/**
 * The Class Outcome.
 */
public class Outcome {

    /**
     * The cost benefit.
     *
     * @uml.property name="costBenefit"
     */
    private double costBenefit;

    /** The description. */
    private String description;

    /**
     * Instantiates a new outcome.
     *
     * @param description
     *            the description
     * @param costBenefit
     *            the cost benefit
     */
    public Outcome(String description, double costBenefit) {
        super();
        this.costBenefit = costBenefit;
        this.description = description;
    }

    /**
     * Gets the cost benefit.
     *
     * @return the cost benefit
     */
    public double getCostBenefit() {
        return this.costBenefit;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

}
