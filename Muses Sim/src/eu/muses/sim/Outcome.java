package eu.muses.sim;


public class Outcome {

	/**
	 * @uml.property  name="costBenefit"
	 */
	private double costBenefit;
	
	private String description;

	public Outcome(String description, double costBenefit) {
		super();
		this.costBenefit = costBenefit;
		this.description = description;
	}

	/**
	 * Getter of the property <tt>costBenefit</tt>
	 * @return  Returns the costBenefit.
	 * @uml.property  name="costBenefit"
	 */
	public double getCostBenefit() {
		return costBenefit;
	}

	public String getDescription() {
		return description;
	}
	
	

}
