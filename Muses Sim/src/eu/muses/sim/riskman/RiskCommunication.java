/*
 * Copyright
 * Jean-Marc Seigneur, Carlos Ballester Lafuente, Xavier Titi
 * University of Geneva
 * 2013 /2014
 *
 */
package eu.muses.sim.riskman;

/**
 * The Class RiskCommunication.
 */
public class RiskCommunication {

	/**
	 * @uml.property name="riskTreatment"
	 * @uml.associationEnd multiplicity="(0 -1)" dimension="1" ordering="true"
	 *                     inverse=
	 *                     "riskCommunication:eu.muses.sim.riskman.RiskTreatment"
	 * @uml.association name="proposes"
	 */
	private RiskTreatment[] riskTreatments;

	/** The textual description. */
	private String textualDescription;

	/**
	 * Instantiates a new risk communication.
	 *
	 * @param riskTreatments
	 *            the risk treatments
	 * @param textualDescription
	 *            the textual description
	 */
	public RiskCommunication(RiskTreatment[] riskTreatments,
			String textualDescription) {
		super();
		this.riskTreatments = riskTreatments;
		this.textualDescription = textualDescription;
	}

	/**
	 * Gets the risk treatments.
	 *
	 * @return the risk treatments
	 */
	public RiskTreatment[] getRiskTreatments() {
		return this.riskTreatments;
	}

	/**
	 * Gets the textual description.
	 *
	 * @return the textual description
	 */
	public String getTextualDescription() {
		return this.textualDescription;
	}

	/**
	 * Checks for risk treatment.
	 *
	 * @param riskTreatment
	 *            the risk treatment
	 * @return true, if successful
	 */
	public boolean hasRiskTreatment(RiskTreatment riskTreatment) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Sets the risk treatment.
	 *
	 * @param riskTreatment
	 *            the new risk treatment
	 */
	public void setRiskTreatment(RiskTreatment[] riskTreatment) {
		this.riskTreatments = riskTreatment;
	}

}
