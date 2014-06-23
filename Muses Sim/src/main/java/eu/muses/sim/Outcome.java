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

	public Outcome() {
		// TODO Auto-generated constructor stub
		super();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.description + " - " + this.costBenefit;
	}

	/**
	 * @param costBenefit
	 *            the costBenefit to set
	 */
	public void setCostBenefit(double costBenefit) {
		this.costBenefit = costBenefit;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
